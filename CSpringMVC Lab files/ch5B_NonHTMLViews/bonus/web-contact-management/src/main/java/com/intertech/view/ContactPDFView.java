package com.intertech.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.intertech.domain.Contact;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Component("pdfView")
public class ContactPDFView extends AbstractPdfView {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void buildPdfDocument(Map model, Document doc, PdfWriter writer,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<Contact> contacts = (List<Contact>) model.get("contactList");
		for (Contact contact : contacts) {
			doc.add(new Paragraph(contact.getLastName() + ", "
					+ contact.getFirstName() + "\tborn: "
					+ contact.getDateOfBirth() + "\tmarried: "
					+ contact.isMarried() + "\t# of Children: "
					+ contact.getChildren() + "\n"));
		}
	}
}
