package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entiteis.Person;
import com.example.demo.servicies.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping("/persons")
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
	}
	
	@GetMapping("/persons/{personId}")
	public Person getPernson(@PathVariable int personId) {
		return personService.getPersonById(personId);
	}
	
	@PostMapping("/persons")
	public ResponseEntity<String> addPerson(@RequestBody Person person) {
		Person newPerson = personService.createNewPerson(person);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newPerson.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/persons2")
	public Person addPerson2(@RequestBody Person person) {
		Person newPerson = personService.createNewPerson(person);
		return newPerson;
	}
	
	@PutMapping("/persons/{personId}")
	public void updatePersonData(@PathVariable int personId, @RequestBody Person person) {
		person.setId(personId);
		personService.updatePerson(person);
	}
	
}
