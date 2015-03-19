package com.clete2.example.service.soap;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.clete2.example.data.Job;
import com.clete2.example.data.Person;
import com.clete2.example.to.JobTO;
import com.clete2.example.to.PersonTO;

@WebService
public interface SOAPService {
	@WebMethod
	@GET
	@Path("/people") 
	List<Person> findAllPeople();
	
	@WebMethod
	List<Person> findPeople(@WebParam(name = "name") String name);
	
	@WebMethod
	Person createPerson(@WebParam(name = "person") PersonTO personTO);
	
	@WebMethod
	Person editPerson(@WebParam(name = "id") Long id, @WebParam(name = "person") PersonTO personTO) throws IllegalAccessException, InvocationTargetException;
	
	@WebMethod
	void deletePerson(@WebParam(name = "id") Long id);
	
	@WebMethod
	List<Job> findAllJobs();
	
	@WebMethod
	List<Job> findJobs(@WebParam(name = "title") String title);
	
	@WebMethod
	Job createJob(@WebParam(name = "job") JobTO jobTO);
	
	@WebMethod
	Job editJob(@WebParam(name = "id") Long id, @WebParam(name = "job") JobTO jobTO) throws IllegalAccessException, InvocationTargetException;
	
	@WebMethod
	void deleteJob(@WebParam(name = "id") Long id);
}
