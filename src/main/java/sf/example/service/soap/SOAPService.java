package sf.example.service.soap;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import sf.example.data.Job;
import sf.example.data.Person;
import sf.example.to.JobTO;
import sf.example.to.PersonTO;

/**
 * SOAP service interface.
 */
@WebService
public interface SOAPService {
	@WebMethod
	List<Person> findAllPeople();
	
	@WebMethod
	Person findPersonById(@WebParam(name = "id") long id);
	
	@WebMethod
	Person createPerson(@WebParam(name = "person") PersonTO personTO);
	
	@WebMethod
	Person editPerson(@WebParam(name = "id") long id, @WebParam(name = "person") PersonTO personTO) throws IllegalAccessException, InvocationTargetException;
	
	@WebMethod
	void deletePerson(@WebParam(name = "id") long id);
	
	@WebMethod
	List<Job> findAllJobs();
	
	@WebMethod
	Job findJob(@WebParam(name = "id") long id);
	
	@WebMethod
	Job createJob(@WebParam(name = "job") JobTO jobTO);
	
	@WebMethod
	Job editJob(@WebParam(name = "id") long id, @WebParam(name = "job") JobTO jobTO) throws IllegalAccessException, InvocationTargetException;
	
	@WebMethod
	void deleteJob(@WebParam(name = "id") long id);
}
