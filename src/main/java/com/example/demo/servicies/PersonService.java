package com.example.demo.servicies;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import com.example.demo.controllers.PersonDB;
import com.example.demo.entiteis.Person;

@Component
public class PersonService {

	public Person getPersonById(int id) {
		return PersonDB.getPerson(id);
	}

	public Person createNewPerson(Person person) throws CreateNewPersonException {
		if(person.getId() > 0) throw new CreateNewPersonException(person);
		PersonDB.putPerson(person);
		return person;
	}
	
	public Person updatePerson(Person person) {
		Person oldPerson = getPersonById(person.getId());
		if(oldPerson == null) return null;
		if(person.getName() != null) oldPerson.setName(person.getName());
		if(person.getBirthDate() != null) oldPerson.setBirthDate(person.getBirthDate());
		return person;
	}
	
	public List<Person> getAllPersons() {
		return PersonDB.getPersons();
	}

	public PersonService(ApplicationArguments args) {
		super();
	}
}

