package com.intertech.view;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

@Component("error")
public class ErrorView extends AbstractView {

	@SuppressWarnings("rawtypes")
	protected void renderMergedOutputModel(Map map, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		PrintWriter out = resp.getWriter();
		out.println("Your request to convert \"" + map.get("amount") + "\" of "
				+ map.get("currency") + " is not a number. ");
		out.println("Hit the back button and try again.");
	}
}
