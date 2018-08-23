package com.intertech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import com.intertech.domain.Contact;

@Aspect
public class AuditorImpl implements Auditor {
	public AuditorImpl(DataSource datasource) {
		this.datasource = datasource;
	}

	private DataSource datasource;

	@Override
	@After("execution(* com.intertech.service.ContactServiceImpl.*(..)) && args(contact)")
	public void audit(JoinPoint jp, Contact contact) {
		insertAudit(jp.getSignature().getName(), contact.getId());
	}

	private void insertAudit(String method, long contactId) {
		try {
			Connection conn = datasource.getConnection();
			PreparedStatement st = conn
					.prepareStatement("insert into contact_audit (id, operation, effective) values (?,?,?)");
			st.setLong(1, contactId);
			st.setString(2, method);
			st.setTimestamp(3,
					new java.sql.Timestamp(System.currentTimeMillis()));
			st.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
