package com.example.demo.servicies;

import com.example.demo.entiteis.Person;

public class PersonServiceException extends RuntimeException {
	
	private static final long serialVersionUID = -6674722572364758446L;
	protected String errorCode;
	protected Person person;

	public String getErrorCode() {
		return errorCode;
	}
	
	public Person getPerson() {
		return person;
	}

	public PersonServiceException(String errorCode, String message, Person person) {
		super(message);
		this.errorCode = errorCode;
		this.person = person;
	}
}
