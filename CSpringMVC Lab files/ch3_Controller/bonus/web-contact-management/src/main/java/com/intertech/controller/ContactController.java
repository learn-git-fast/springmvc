package com.intertech.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
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

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("d-MM-yyyy");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@ExceptionHandler(org.springframework.validation.BindException.class)
	protected String badData(Errors errors) {
		return "unsuccessfuladd";
	}

	@RequestMapping(value = "addcontact.request", method = RequestMethod.GET)
	protected String showContactForm() {
		return "editcontact";
	}

	@RequestMapping(value = "addcontact.request", method = RequestMethod.POST)
	protected String addContact(Contact contact) {
		contactService.addContact(contact);
		return "successfuladd";
	}

	@RequestMapping("deletecontact.request")
	protected String deleteContact(@RequestParam int id) {
		contactService.removeContact(id);
		return "forward:/displaycontacts.request";
	}

	@RequestMapping("displaycontacts.request")
	protected ModelAndView displayContacts() {
		List<Contact> contacts = contactService.getContacts();
		return new ModelAndView("displaycontacts", "contactList", contacts);
	}
}
