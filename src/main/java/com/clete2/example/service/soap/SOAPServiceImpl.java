package com.clete2.example.service.soap;

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
import com.clete2.example.service.NullAwareBeanUtils;
import com.clete2.example.to.JobTO;
import com.clete2.example.to.PersonTO;

@Component
public class SOAPServiceImpl implements SOAPService {
	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private NullAwareBeanUtils nullAwareBeanUtils;

	@Override
	public List<Person> findAllPeople() {
		List<Person> people = new ArrayList<Person>();
		personRepository.findAll().forEach((person) -> people.add(person));

		return people;
	}

	@Override
	public List<Person> findPeople(String name) {
		List<Person> people = personRepository.findByName(name);

		return people;
	}

	@Override
	public Person createPerson(PersonTO personTO) {
		Person person = new Person();
		BeanUtils.copyProperties(personTO, person);

		person.setJob(jobRepository.findOne(personTO.getJobId()));

		return personRepository.save(person);
	}

	@Override
	public Person editPerson(Long id, PersonTO personTO) throws IllegalAccessException, InvocationTargetException {
		Person person = personRepository.findOne(id);
		nullAwareBeanUtils.copyProperties(person, personTO);
		personRepository.save(person);

		return person;
	}

	@Override
	public void deletePerson(Long id) {
		personRepository.delete(id);
	}

	@Override
	public List<Job> findAllJobs() {
		List<Job> jobs = new ArrayList<Job>();
		jobRepository.findAll().forEach((job) -> jobs.add(job));

		return jobs;
	}

	@Override
	public List<Job> findJobs(String title) {
		return jobRepository.findByTitle(title);
	}

	@Override
	public Job createJob(JobTO jobTO) {
		Job job = new Job();
		BeanUtils.copyProperties(jobTO, job);

		return jobRepository.save(job);
	}

	@Override
	public Job editJob(Long id, JobTO jobTO) throws IllegalAccessException, InvocationTargetException {
		Job job = jobRepository.findOne(id);
		nullAwareBeanUtils.copyProperties(job, jobTO);
		jobRepository.save(job);
		
		return job;
	}

	@Override
	public void deleteJob(Long id) {
		jobRepository.delete(id);
	}
}