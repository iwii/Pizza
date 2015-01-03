package com.pizza.delivery.services;

import java.util.List;

import com.pizza.delivery.domain.Drink;

@SuppressWarnings("hiding")
public interface DrinkDAO<Drink> extends AbstractDAO<Drink, Long> {
	List<Drink> findByName(String name);
}
