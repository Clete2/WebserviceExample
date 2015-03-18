package com.clete2.example.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long> {
	List<Job> findByTitle(String title);
}
