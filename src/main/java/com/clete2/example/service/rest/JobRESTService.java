package com.clete2.example.service.rest;

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

import com.clete2.example.data.Job;
import com.clete2.example.service.ServiceBO;
import com.clete2.example.to.JobTO;

@Component
@Path("/jobs")
public class JobRESTService {
	@Autowired
	private ServiceBO serviceBO;
	
	@GET
	@Path("")
	@Produces("application/json")
	public List<Job> jobs() {
		return serviceBO.jobs();
	}
	
	@POST
	@Path("")
	@Produces("application/json")
	public Job createJob(JobTO jobTO) {
		return serviceBO.createJob(jobTO);
	}
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	public Job jobById(@PathParam("id") long id) {
		return serviceBO.jobById(id);
	}
	
	@POST
	@Path("{id}")
	@Produces("application/json")
	public Job editJobById(@PathParam("id") long id, JobTO jobTO) throws IllegalAccessException, InvocationTargetException {
		return serviceBO.editJobById(id, jobTO);
	}
	
	@DELETE
	@Path("{id}")
	public void deleteJob(@PathParam("id") Long id) {
		serviceBO.deleteJob(id);
	}
}