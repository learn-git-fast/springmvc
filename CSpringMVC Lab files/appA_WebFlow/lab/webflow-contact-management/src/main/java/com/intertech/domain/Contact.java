package com.intertech.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
public class Contact implements Serializable {
	private Long id = 0L;
	@NotNull
	@Size(min = 1)
	private String firstName;
	@NotNull
	@Size(min = 1)
	private String lastName;
	@Past
	@DateTimeFormat(pattern="MMM dd, YYYY")
	private Date dateOfBirth;
	private boolean married;
	@Min(0)
	@Max(20)
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
