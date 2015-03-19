package com.clete2.example.service.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.clete2.example.data.Job;
import com.clete2.example.data.Person;

@WebService
public interface PeopleSOAPService {
	@WebMethod
	@GET
	@Path("/people") 
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
