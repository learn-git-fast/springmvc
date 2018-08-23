package com.intertech.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

public class WebMVCApplicationInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		ServletRegistration.Dynamic registration = container.addServlet(
				"dispatcher", new DispatcherServlet());
		registration.setLoadOnStartup(1);
		registration.addMapping("*.request");
	}
}
