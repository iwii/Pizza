package com.pizza.delivery.services;

import java.util.List;

import com.pizza.delivery.domain.Ingredient;

public interface IngredientDAO<Igredient> extends AbstractDAO<Igredient, Long>{
	List<Ingredient> findByName(String name);

}
