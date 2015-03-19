package com.clete2.example.service.rest;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clete2.example.data.Job;
import com.clete2.example.data.JobRepository;
import com.clete2.example.service.NullAwareBeanUtils;
import com.clete2.example.to.JobTO;

@Component
@Path("/jobs")
public class JobRESTService {
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private NullAwareBeanUtils nullAwareBeanUtils;
	
	@GET
	@Path("")
	@Produces("application/json")
	public List<Job> jobs() {
		List<Job> jobs = new ArrayList<Job>();
		jobRepository.findAll().forEach((job) -> jobs.add(job));
		
		return jobs;
	}
	
	@POST
	@Path("")
	@Produces("application/json")
	public Job createJob(JobTO jobTO) {
		Job job = new Job();
		BeanUtils.copyProperties(jobTO, job);
		
		jobRepository.save(job);
		
		return job;
	}
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	public Job jobById(@PathParam("id") Long id) {
		return jobRepository.findOne(id);
	}
	
	@POST
	@Path("{id}")
	@Produces("application/json")
	public Job editJobById(@PathParam("id") Long id, JobTO jobTO) throws IllegalAccessException, InvocationTargetException {
		Job job = jobRepository.findOne(id);
		nullAwareBeanUtils.copyProperties(job, jobTO);
		jobRepository.save(job);
		
		return job;
	}
	
	@DELETE
	@Path("{id}")
	public void deleteJob(@PathParam("id") Long id) {
		jobRepository.delete(id);
	}
}
