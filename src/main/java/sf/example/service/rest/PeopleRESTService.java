package sf.example.service.rest;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import sf.example.data.Person;
import sf.example.service.ServiceBO;
import sf.example.to.PersonTO;

/**
 * REST service.
 */
@RestController
@RequestMapping("/people")
public class PeopleRESTService {
	@Autowired
	private ServiceBO serviceBO;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ApiOperation("Get people")
	public List<Person> people() {
		return serviceBO.people();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ApiOperation("Create job")
	@ApiImplicitParams({ 
		@ApiImplicitParam(value = "ID to edit", name = "id", paramType = "path", required = true),
		@ApiImplicitParam(value = "Name", name = "name", paramType = "query"),
		@ApiImplicitParam(value = "Notes", name = "notes", paramType = "query"),
		@ApiImplicitParam(value = "Does this person have nice hair?", name = "hasNiceHair", paramType = "query"),
		@ApiImplicitParam(value = "Pay percentile (0-100)", name = "payPercentile", paramType = "query"),
		@ApiImplicitParam(value = "Job ID", name = "jobId", paramType = "query")
	})
	public Person createPerson(PersonTO personTO) {
		return serviceBO.createPerson(personTO);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ApiOperation("Retrieve person by ID")
	@ApiImplicitParam(value = "ID to retrieve", name = "id", paramType = "path", required = true)
	public Person personById(@PathVariable long id) {
		return serviceBO.personById(id);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	@ApiOperation("Edit person by ID")
	@ApiImplicitParams({ 
		@ApiImplicitParam(value = "ID to edit", name = "id", paramType = "path", required = true),
		@ApiImplicitParam(value = "Name", name = "name", paramType = "query"),
		@ApiImplicitParam(value = "Notes", name = "notes", paramType = "query"),
		@ApiImplicitParam(value = "Does this person have nice hair?", name = "hasNiceHair", paramType = "query"),
		@ApiImplicitParam(value = "Pay percentile (0-100)", name = "payPercentile", paramType = "query"),
		@ApiImplicitParam(value = "Job ID", name = "jobId", paramType = "query")
	})
	public Person editPersonById(@PathVariable long id, PersonTO personTO)
			throws IllegalAccessException, InvocationTargetException {
		return serviceBO.editPersonById(id, personTO);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ApiOperation("Delete person by ID")
	@ApiImplicitParam(value = "ID to delete", name = "id", paramType = "path", required = true)
	public void deletePerson(@PathVariable long id) {
		serviceBO.deletePerson(id);
	}
}
