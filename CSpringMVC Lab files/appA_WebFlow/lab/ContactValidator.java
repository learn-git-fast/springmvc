package com.intertech.domain;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component
public class ContactValidator {

	public void validateGetcontact(Contact contact, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "firstName", "firstNameRequired");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "lastNameRequired");
		if ((contact.getChildren() < 0) || (contact.getChildren() > 20)) {
			errors.rejectValue("children", "childrenOutOfRange");
		}
	}
}
