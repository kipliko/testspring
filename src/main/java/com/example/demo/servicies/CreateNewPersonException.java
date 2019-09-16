package com.example.demo.servicies;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.entiteis.Person;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CreateNewPersonException extends PersonServiceException {
	
	private static final long serialVersionUID = 8549803407390682007L;

	CreateNewPersonException(Person person) {
		super("ERR-1", "The specified person cannot be created: the id should not be defined", person);
	}
}