package com.intertech.domain;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

public class Contact {
	private Long id = 0L;
	@Value("#{'Pat'}")	
	private String firstName;
	@Value("#{'Doe'}")
	private String lastName;
	@Value("#{'1900/1/1'}")
	private Date dateOfBirth;
	@Value("#{'false'}")
	private boolean married;
	@Value("#{0}")
	private int children;


	public Contact(String firstName, String lastName, Date dateOfBirth,
			boolean married, int children) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.married = married;
		this.children = children;
	}

	public Contact(Long id, String firstName, String lastName,
			Date dateOfBirth, boolean married, int children) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.married = married;
		this.children = children;
	}

	public Contact() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public double getAge() {
		if (dateOfBirth != null) {
			long difference = System.currentTimeMillis()
					- dateOfBirth.getTime();
			return difference / 1000 / 60 / 60 / 24 / 365;
		} else {
			return 0.0;
		}
	}

	public String toString() {
		return (firstName + " " + lastName + "(" + id + ")");
	}

}
