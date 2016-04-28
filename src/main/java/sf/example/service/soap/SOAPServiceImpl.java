package sf.example.service.soap;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sf.example.data.Job;
import sf.example.data.Person;
import sf.example.service.ServiceBO;
import sf.example.to.JobTO;
import sf.example.to.PersonTO;

/**
 * SOAP service implementation.
 */
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