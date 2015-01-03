package com.pizza.delivery.services;
import java.io.Serializable;
import java.util.List;

public interface AbstractDAO <E, K extends Serializable>{	
	E create(E entity);
	E update(E entity);
	void delete(K key);
	E findById(K key);
	List<E> listAll();
}