package com.pizza.delivery.services.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pizza.delivery.domain.Person;
import com.pizza.delivery.services.PersonDAO;

@Repository
public class PersonDAOImpl extends AbstractDAOImpl<Person, Long> implements PersonDAO{

	@Override
	public List<Person> list() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
