package com.clete2.example.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {
	List<Person> findByName(String name);
}
