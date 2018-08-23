package com.intertech.support;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {
	
	private SimpleDateFormat format;

	public DateConverter(SimpleDateFormat format) {
		this.format = format;
	}

	@Override
	public Date convert(String dateString) {
		try {
			return format.parse(dateString);
		} catch (ParseException e) {
			throw new IllegalArgumentException(
					"Date string not formatted correctly.");
		}
	}
}
