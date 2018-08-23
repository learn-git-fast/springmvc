package com.intertech.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.intertech.dao.ContactDao;
import com.intertech.domain.Contact;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

	// @Autowired
	// @Qualifier("contactDao")
	// @Resource(name = "contactDao")
	@Inject
	@Named("contactDao")
	private ContactDao dao;

	public ContactDao getDao() {
		return dao;
	}

	public void setDao(ContactDao dao) {
		this.dao = dao;
	}

	@Override
	public Contact addContact(String first, String last, Date dob,
			boolean married, int children) {
		Contact c = new Contact(first, last, dob, married, children);
		long id = dao.saveContact(c);
		c.setId(id);
		return c;
	}

	@Override
	public void addContact(Contact contact) {
		long id = dao.saveContact(contact);
		contact.setId(id);
		//causeFailure();
	}

	@Override
	public void removeContact(Contact contact) {
		removeContact(contact.getId());
	}

	@Override
	public void removeContact(long id) {
		dao.deleteContact(id);
	}

	@Override
	public void updateContact(Contact contact) {
		dao.updateContact(contact);
	}

	@Override
	public Contact getContact(long id) {
		return dao.getContact(id);
	}

	@Override
	public List<Contact> getContacts() {
		return dao.getContacts();
	}

	private void causeFailure() {
		throw new java.lang.RuntimeException("kill it now");
	}

}
