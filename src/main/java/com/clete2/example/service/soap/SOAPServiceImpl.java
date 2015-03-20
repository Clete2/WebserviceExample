package com.clete2.example.service.soap;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clete2.example.data.Job;
import com.clete2.example.data.Person;
import com.clete2.example.service.ServiceBO;
import com.clete2.example.to.JobTO;
import com.clete2.example.to.PersonTO;

@Component
public class SOAPServiceImpl implements SOAPService {
	@Autowired
	private ServiceBO serviceBO;

	@Override
	public List<Person> findAllPeople() {
		return serviceBO.people();
	}

	@Override
	public Person findPersonById(long id) {
		return serviceBO.personById(id);
	}

	@Override
	public Person createPerson(PersonTO personTO) {
		return serviceBO.createPerson(personTO);
	}

	@Override
	public Person editPerson(long id, PersonTO personTO) throws IllegalAccessException, InvocationTargetException {
		return serviceBO.editPersonById(id, personTO);
	}

	@Override
	public void deletePerson(long id) {
		serviceBO.deletePerson(id);
	}

	@Override
	public List<Job> findAllJobs() {
		return serviceBO.jobs();
	}

	@Override
	public Job findJob(long id) {
		return serviceBO.jobById(id);
	}

	@Override
	public Job createJob(JobTO jobTO) {
		return serviceBO.createJob(jobTO);
	}

	@Override
	public Job editJob(long id, JobTO jobTO) throws IllegalAccessException, InvocationTargetException {
		return serviceBO.editJobById(id, jobTO);
	}

	@Override
	public void deleteJob(long id) {
		serviceBO.deleteJob(id);;
	}
}