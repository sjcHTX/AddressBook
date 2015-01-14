package org.sunil.addressbook.dao;

import java.util.List;

import org.sunil.addressbook.entity.Contact;

public interface ContactDao {
	public void addContact(Contact contact );
	public List<Contact> listContact();
	public List<Contact> listContactAllDetails();
	public void remove(String id);
	//public void remove(String id);
}
