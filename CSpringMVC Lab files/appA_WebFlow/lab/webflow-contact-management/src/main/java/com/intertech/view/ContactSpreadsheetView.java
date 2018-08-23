package com.intertech.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.intertech.domain.Contact;

@Component("excelView")
public class ContactSpreadsheetView extends AbstractExcelView {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<Contact> contacts = (List<Contact>) model.get("contactList");
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow header = sheet.createRow(0);
		HSSFCell c = header.createCell(0);
		super.setText(c, "First");
		c = header.createCell(1);
		super.setText(c, "Last");
		c = header.createCell(2);
		super.setText(c, "Date of Birth");
		c = header.createCell(3);
		super.setText(c, "Married");
		c = header.createCell(4);
		super.setText(c, "Children");
		int row = 1;
		for (Contact contact : contacts) {
			HSSFRow custRow = sheet.createRow(row);
			c = custRow.createCell(0);
			super.setText(c, contact.getFirstName());
			c = custRow.createCell(1);
			super.setText(c, contact.getLastName());
			c = custRow.createCell(2);
			c.setCellValue(contact.getDateOfBirth());
			c = custRow.createCell(3);
			c.setCellValue(contact.isMarried());
			c = custRow.createCell(4);
			c.setCellValue(contact.getChildren());
			row++;
		}
	}
}
