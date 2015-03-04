package com.pizza.delivery.services;

import java.util.List;

import com.pizza.delivery.domain.Sauce;

public interface SauceDAO<Sauce> extends AbstractDAO<Sauce, Long>{
	List<Sauce> findByName(String name);
}
