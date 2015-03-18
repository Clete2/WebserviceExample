package com.clete2.example.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.clete2.example.data.Job;
import com.clete2.example.data.Person;

@WebService
public interface PeopleService {
	@WebMethod
	List<Person> findAllPeople();
	
	@WebMethod
	List<Person> findPeople(@WebParam(name = "name") String name);
	
	@WebMethod
	Person createPerson(@WebParam(name = "person") Person person);
	
	@WebMethod
	List<Job> findAllJobs();
	
	@WebMethod
	List<Job> findJobs(@WebParam(name = "title") String title);
}
