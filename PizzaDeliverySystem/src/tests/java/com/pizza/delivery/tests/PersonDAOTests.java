package com.pizza.delivery.tests;

import static org.springframework.util.Assert.notNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.pizza.delivery.domain.Person;
import com.pizza.delivery.services.PersonDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"testApplicationContext.xml"})
public class PersonDAOTests {
	
	@Autowired
	private PersonDAO personDAO;
	
	@Test
	public void findFirstPerson(){
	Person person = new Person();
	person.setCity("Resovia");
	person.setFirstName("Jhon");
	person.setLastName("Cure");
	person.setStatus("");
	Person createdPerson = personDAO.update(person);
		
	
	
	notNull(createdPerson);
		
	}
	
}
