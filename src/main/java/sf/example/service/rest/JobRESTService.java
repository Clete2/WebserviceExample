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
import sf.example.data.Job;
import sf.example.service.ServiceBO;
import sf.example.to.JobTO;

/**
 * REST service.
 */
@RestController
@RequestMapping("/jobs")
public class JobRESTService {
	@Autowired
	private ServiceBO serviceBO;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ApiOperation("Get jobs")
	public List<Job> jobs() {
		return serviceBO.jobs();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ApiOperation("Create job")
	@ApiImplicitParams({ @ApiImplicitParam(value = "Job title", name = "title", paramType = "query", required = true),
			@ApiImplicitParam(value = "Minimum pay in dollars", name = "minPay", paramType = "query", required = true),
			@ApiImplicitParam(value = "Maximum pay in dollars", name = "maxPay", paramType = "query", required = true) })
	public Job createJob(JobTO jobTO) {
		return serviceBO.createJob(jobTO);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ApiOperation("Retrieve job by ID")
	@ApiImplicitParam(value = "ID to retrieve", name = "id", paramType = "path", required = true)
	public Job jobById(@PathVariable long id) {
		return serviceBO.jobById(id);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	@ApiOperation("Edit job by ID")
	@ApiImplicitParams({ @ApiImplicitParam(value = "Job title", name = "title", paramType = "query", required = true),
			@ApiImplicitParam(value = "Minimum pay in dollars", name = "minPay", paramType = "query", required = true),
			@ApiImplicitParam(value = "Maximum pay in dollars", name = "maxPay", paramType = "query", required = true),
			@ApiImplicitParam(value = "ID to edit", name = "id", paramType = "path", required = true) })
	public Job editJobById(@PathVariable long id, JobTO jobTO)
			throws IllegalAccessException, InvocationTargetException {
		return serviceBO.editJobById(id, jobTO);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ApiOperation("Delete job by ID")
	@ApiImplicitParam(value = "ID to delete", name = "id", paramType = "path", required = true)
	public void deleteJob(@PathVariable long id) {
		serviceBO.deleteJob(id);
	}
}
