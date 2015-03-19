package com.clete2.example.service.soap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clete2.example.data.Job;
import com.clete2.example.data.JobRepository;
import com.clete2.example.data.Person;
import com.clete2.example.data.PersonRepository;

@Component
public class PeopleSOAPServiceImpl implements PeopleSOAPService {
	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private JobRepository jobRepository;

	@Override
	public List<Person> findAllPeople() {
		List<Person> people = new ArrayList<Person>();
		personRepository.findAll().forEach((person) -> people.add(person));
		people.forEach((person) -> person.calculateSalary());
		
		return people;
	}

	@Override
	public List<Person> findPeople(String name) {
		List<Person> people = personRepository.findByName(name);
		people.forEach((person) -> person.calculateSalary());

		return people;
	}

	@Override
	public Person createPerson(Person person) {
		return personRepository.save(person);
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
}