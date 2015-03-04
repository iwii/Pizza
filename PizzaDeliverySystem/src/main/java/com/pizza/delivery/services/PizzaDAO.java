package com.pizza.delivery.services;

import java.util.List;

import com.pizza.delivery.domain.Pizza;

public interface PizzaDAO<K, E> extends AbstractDAO<Pizza, Long>{
	
	List<Pizza> findByName(String name);
	Pizza getStringPizza();
}
