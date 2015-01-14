package org.sunil.addressbook.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sunil.addressbook.entity.Contact;



@Repository
//@Transactional
public class ContactDaoImpl implements ContactDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//@Transactional
	public void addContact(Contact contact) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(contact);
	}

	@SuppressWarnings("unchecked")
	//@Transactional(readOnly = true)
	public List<Contact> listContact() {
		
		Query query = sessionFactory.getCurrentSession().createQuery("from Contact C");
		return (List<Contact>) query.list();
	}
	
	@SuppressWarnings("unchecked")
	//@Transactional(readOnly = true)
	public List<Contact> listContactAllDetails() {
		List<Contact> listContactAllDetails = (List<Contact>) sessionFactory.getCurrentSession().getNamedQuery("Contact.listContactAllDetails").list();
		//List<Contact> listContactAllDetails = (List<Contact>) sessionFactory.getCurrentSession().createQuery("from Contact").list();
		return listContactAllDetails;
	}

	public void remove(String id) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(Contact.class, id);
		sessionFactory.getCurrentSession().delete(contact);
	}
	
/*	public void remove(String id) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(Contact.class, id);
		sessionFactory.getCurrentSession().delete(contact);
	}*/

}
