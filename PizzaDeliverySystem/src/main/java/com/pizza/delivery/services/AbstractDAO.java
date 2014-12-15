package com.pizza.delivery.services;
import java.io.Serializable;
import java.util.List;

public interface AbstractDAO <E, K extends Serializable>{

	
	E create(E entity);
	E read(K key);
	E update(E entity);
	void delete(E entity);
	E findById(K key);
	List<E> list();
	

	
}