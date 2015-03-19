package com.clete2.example.service.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clete2.example.data.Person;
import com.clete2.example.data.PersonRepository;

@Component
public class PeopleRESTServiceImpl {
	@Autowired
	private PersonRepository personRepository;
	
	@GET
	@Path("/people")
	public Person people() {		
		List<Person> people = new ArrayList<Person>();
		personRepository.findAll().forEach((person) -> people.add(person));
		
		return people.get(0);
	}
}
