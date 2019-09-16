package com.example.demo.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entiteis.Person;

@Configuration
public class PersonDB {
	
	protected static HashMap<Integer, Person> personDB = new HashMap<Integer, Person>();
	protected static int lastId = 0;
	protected static AtomicInteger counter = new AtomicInteger();
	
	public static Person getPerson(int id) {
		return personDB.get(id);
	}
	
	public static void putPerson(Person person) {
		person.setId(counter.incrementAndGet());
		personDB.put(person.getId(), person);
	}
	
	public static List<Person> getPersons() {
		return new ArrayList<Person>(personDB.values());
	}
	
	@Bean
	public CommandLineRunner initDatabase() {
		return args -> {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			putPerson(new Person(1, "Pippo", new Date()));
			putPerson(new Person(2, "Pluto", dateFormat.parse("2018-05-31")));
			lastId = 2;
		};
	}
}
