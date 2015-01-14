package org.sunil.addressbook.service;

import java.util.List;

import org.sunil.addressbook.entity.Contact;

public interface ContactService {
	public void addContact(Contact contact);

	public List<Contact> listContact();

	public List<Contact> listContactAllDetails();

	public void remove(String id);
	//public void remove(String uuid);
}
