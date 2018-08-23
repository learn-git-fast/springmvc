package com.intertech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.intertech.domain.Contact;
import com.intertech.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	@RequestMapping(value = "addcontact.request", method = RequestMethod.GET)
	protected String showContactForm() {
		return "editcontact";
	}
	
	@RequestMapping(value = "addcontact.request", method = RequestMethod.POST)
	protected String addContact(Contact contact, Errors errors) {
		if (errors.hasErrors()) {
			return "editcontact";
		}
		contactService.addContact(contact);
		return "successfuladd";
	}

	@RequestMapping("displaycontacts.request")
	protected ModelAndView displayContacts() {
		List<Contact> contacts = contactService.getContacts();
		return new ModelAndView("displaycontacts", "contactList", contacts);
	}

	@RequestMapping("deletecontact.request")
	protected String deleteContact(@RequestParam int id) {
		contactService.removeContact(id);
		return "forward:/displaycontacts.request";
	}
}
