package org.sunil.addressbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sunil.addressbook.dao.ContactDao;
import org.sunil.addressbook.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDao contactdao;

	@Transactional
	public void addContact(Contact contact) {
		contactdao.addContact(contact);
	}

	@Transactional(readOnly=true)
	public List<Contact> listContact() {
		return contactdao.listContact();
	}

	
	@Transactional 
	public void remove(String id){ 
		contactdao.remove(id);
	}	 

/*	@Transactional
	public void remove(String id) {
		contactdao.remove(id);
	}*/

	@Transactional(readOnly=true)
	public List<Contact> listContactAllDetails() {
		return contactdao.listContactAllDetails();

	}

}
