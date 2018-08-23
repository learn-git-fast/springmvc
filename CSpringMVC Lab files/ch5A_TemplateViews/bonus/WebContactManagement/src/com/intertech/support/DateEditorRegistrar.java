package com.intertech.support;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class DateEditorRegistrar implements PropertyEditorRegistrar {

	private SimpleDateFormat format;
	private boolean allowEmpty = false;

	public DateEditorRegistrar(SimpleDateFormat format, boolean allowEmpty) {
		this.format = format;
		this.allowEmpty = allowEmpty;
	}

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Date.class, new CustomDateEditor(format,
				allowEmpty));
	}

}
