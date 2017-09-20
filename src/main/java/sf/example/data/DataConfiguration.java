package sf.example.data;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for the database.
 */
@Configuration
public class DataConfiguration {
	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private PersonRepository personRepository;

	/**
	 * Inserts some sample data into the database.
	 * By default with Spring-data-JPA, a H2 database is initialized.
	 */
	@PostConstruct
	public void initializeData() {
		Job peon = jobRepository.save(new Job("Peon", 10000, 20000));
		Job boss = jobRepository.save(new Job("BOSS", 300000, 1000000));

		personRepository.save(new Person("Clete", "Likes Spring.", 22.87, peon));
		personRepository.save(new Person("Pete", "Is the BOSS!", 999.5, boss, true));
	}
}
