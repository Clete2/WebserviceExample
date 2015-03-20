package com.clete2.example.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clete2.example.data.Job;
import com.clete2.example.data.JobRepository;
import com.clete2.example.data.Person;
import com.clete2.example.data.PersonRepository;
import com.clete2.example.to.JobTO;
import com.clete2.example.to.PersonTO;

@Component
public class ServiceBO {
	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private NullAwareBeanUtils nullAwareBeanUtils;

	public List<Person> people() {
		List<Person> people = new ArrayList<Person>();
		personRepository.findAll().forEach((person) -> people.add(person));

		return people;
	}

	public Person createPerson(PersonTO personTO) {
		Person person = new Person();
		BeanUtils.copyProperties(personTO, person);

		person.setJob(jobRepository.findOne(personTO.getJobId()));

		personRepository.save(person);

		return person;
	}

	public Person personById(long id) {
		return personRepository.findOne(id);
	}

	public Person editPersonById(long id, PersonTO personTO) throws IllegalAccessException, InvocationTargetException {
		Person person = personRepository.findOne(id);
		nullAwareBeanUtils.copyProperties(person, personTO);
		personRepository.save(person);

		return person;
	}

	public void deletePerson(long id) {
		personRepository.delete(id);
	}

	public List<Job> jobs() {
		List<Job> jobs = new ArrayList<Job>();
		jobRepository.findAll().forEach((job) -> jobs.add(job));

		return jobs;
	}

	public Job createJob(JobTO jobTO) {
		Job job = new Job();
		BeanUtils.copyProperties(jobTO, job);

		jobRepository.save(job);

		return job;
	}

	public Job jobById(long id) {
		return jobRepository.findOne(id);
	}

	public Job editJobById(long id, JobTO jobTO) throws IllegalAccessException, InvocationTargetException {
		Job job = jobRepository.findOne(id);
		nullAwareBeanUtils.copyProperties(job, jobTO);
		jobRepository.save(job);

		return job;
	}

	public void deleteJob(long id) {
		jobRepository.delete(id);
	}
}
