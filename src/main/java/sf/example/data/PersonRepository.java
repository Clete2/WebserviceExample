package sf.example.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * Spring provides the CrudRepository interface and automatically implements common CRUD functionality.
 * Adding our own method allows us to extend the CrudRepository interface and have Spring implement it
 * without us writing any code.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findByName(String name);
}
