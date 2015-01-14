package org.sunil.addressbook.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.sunil.addressbook.entity.Address;
import org.sunil.addressbook.entity.Contact;
import org.sunil.addressbook.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	@ModelAttribute("contact")
	public Contact getContact() {
		Contact contact = new Contact();

		return contact;
	}

	@ModelAttribute("contacts")
	public List<Contact> getContacts() {
		List<Contact> listOfContactsAllDetails = contactService
				.listContactAllDetails();
		return listOfContactsAllDetails;
	}

	@RequestMapping({ "/index", "/" })
	public String listContacts() {
		return "contact";
	}
	

	/*
	 * @RequestMapping(value = "/add", method = RequestMethod.POST) public
	 * String addContact(@ModelAttribute("contact") Contact contact,
	 * BindingResult result){ contactService.addContact(contact); return
	 * "redirect:/index"; }
	 */

	@RequestMapping(value="/add", method={RequestMethod.POST})
	public String addContact(@ModelAttribute("contact") @Valid Contact contact, BindingResult result, HttpServletRequest request) {
		String method = request.getMethod();
		
		if(result.hasErrors()){
			return "contactError";
		}
		
		ArrayList<Address> addresses = (ArrayList<Address>) contact.getAddresses();
		for (Iterator<Address> iterator = addresses.iterator(); iterator.hasNext();) {
			Address address = (Address) iterator.next();
/*			if(address.getAddressType().equals("BUSINESS")){
				BusinessAddress businessAddress = new BusinessAddress();
				businessAddress.setAddress(address.getAddress());
				businessAddress.setAddressType(address.getAddressType());
				address = businessAddress;
			}*/
			address.setContact(contact);			
		}		
		
		contactService.addContact(contact);
		/*
		 * logging sent business order did something
		 */
		return "redirect:/index";
	}

	@RequestMapping("/delete/{contactId}")
	public String deleteContact(@PathVariable("contactId") String contactId) {

		Contact contact = new Contact();
		contact.setId(contactId);
		contactService.remove(contactId);

		return "redirect:/index";
	}

}
