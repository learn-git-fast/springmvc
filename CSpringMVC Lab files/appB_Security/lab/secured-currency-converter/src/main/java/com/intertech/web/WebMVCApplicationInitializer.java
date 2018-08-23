package com.intertech.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebMVCApplicationInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		appContext.setConfigLocation("/WEB-INF/mvc-beans.xml");
		ContextLoaderListener listener = new ContextLoaderListener();
		container.addListener(listener);
		container.setInitParameter("contextConfigLocation",
				"/WEB-INF/spring-beans.xml");
		ServletRegistration.Dynamic registration = container.addServlet(
				"dispatcher", new DispatcherServlet(appContext));
		registration.setLoadOnStartup(1);
		registration.addMapping("*.request");
	}
}
