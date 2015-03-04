package com.pizza.delivery.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pizza.delivery.domain.Person;
import com.pizza.delivery.services.PersonDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "testApplicationContext.xml" })
public class PersonDAOTests {

	@SuppressWarnings("rawtypes")
	@Autowired
	private PersonDAO<Person> personDAO;
	private Person person;

	@Before
	public void setUp() {
		person = new Person();
		person.setCity("Rzeszow");
		person.setFirstName("Anatol");
		person.setLastName("Krokodyl1");
		person.setStatus("");
		person = personDAO.create(person);
	}

	@After
	public void afterTest() {
		personDAO.delete(person.getPersonId());
	}
	
	@Test
	public void testFindByIdPerson() {
		Person personToCompare = personDAO.findById(person.getPersonId());
		Assert.assertEquals(personToCompare.getCity(), person.getCity());
        Assert.assertEquals(personToCompare.getFirstName(), person.getFirstName());
        Assert.assertEquals(personToCompare.getLastName(), person.getLastName());
        
        return;
		
		//Person findedPerson = personDAO.findById(person.getPersonId());
		//Assert.assertNotNull("Find person should be not null", findedPerson);
		}
	
}
