package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.entiteis.Person;
import com.example.demo.servicies.CreateNewPersonException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CreateNewPersonException.class)
	public final ResponseEntity<PersonErrorDetails> handleUserNotFoundException(CreateNewPersonException ex, WebRequest request) {
		PersonErrorDetails errorDetails = new PersonErrorDetails(ex);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
}

class PersonErrorDetails {
	protected int status;
	protected String errorCode;
	protected String message;
	protected Person person;

	PersonErrorDetails(CreateNewPersonException ex) {
		this.status = 400;
		this.errorCode = ex.getErrorCode();
		this.message = ex.getMessage();
		this.person = ex.getPerson();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

	public Person getPerson() {
		return person;
	}

	public int getStatus() {
		return status;
	}
}
