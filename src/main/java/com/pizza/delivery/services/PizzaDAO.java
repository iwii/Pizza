package com.pizza.delivery.services;

import java.util.List;

import com.pizza.delivery.domain.Pizza;
import com.pizza.delivery.services.AbstractDAO;

public interface PizzaDAO<K, E> extends AbstractDAO<Pizza, Long>{
	
	List<Pizza> findByName(String name);
	Pizza getStringPizza();
}
