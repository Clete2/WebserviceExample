package sf.example.service.rest;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sf.example.data.Person;
import sf.example.service.ServiceBO;
import sf.example.to.PersonTO;

/**
 * REST service.
 */
@Component
@Path("/people")
public class PeopleRESTService {
	@Autowired
	private ServiceBO serviceBO;
	
	@GET
	@Path("")
	@Produces("application/json")
	public List<Person> people() {
		return serviceBO.people();
	}

	@POST
	@Path("")
	@Produces("application/json")
	public Person createPerson(PersonTO personTO) {
		return serviceBO.createPerson(personTO);
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Person personById(@PathParam("id") long id) {
		return serviceBO.personById(id);
	}

	@POST
	@Path("{id}")
	@Produces("application/json")
	public Person editPersonById(@PathParam("id") long id, PersonTO personTO) throws IllegalAccessException, InvocationTargetException {
		return serviceBO.editPersonById(id, personTO);
	}

	@DELETE
	@Path("{id}")
	public void deletePerson(@PathParam("id") long id) {
		serviceBO.deletePerson(id);
	}
}
