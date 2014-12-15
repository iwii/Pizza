package com.pizza.delivery.services.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import com.pizza.delivery.services.AbstractDAO;

/**
 * Basic DAO operations dependent with Hibernate's specific classes
 * 
 * @see EntityManager
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public abstract class AbstractDAOImpl<E, K extends Serializable> implements
		AbstractDAO<E, K> {

	@PersistenceContext
	protected EntityManager entityManager;
	protected Class<E> e;

	@SuppressWarnings("unchecked")
	public AbstractDAOImpl() {
		e = (Class<E>) ((ParameterizedType) (getClass().getGenericSuperclass()))
				.getActualTypeArguments()[0];
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entity) {
		this.entityManager = entity;
	}

	@Override
	public E create(E entity) {
		this.entityManager.persist(e);
		entityManager.flush();
		
		return entity;
	}

	@Override
	public E read(K key) {
		return this.entityManager.find(e, key);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public E update(E entity) {
		return this.entityManager.merge(entity);
	}

	@Override
	public void delete(E entity) {
		this.entityManager.remove(entity);
	}

	@Override
	public E findById(K key) {
		return (E) this.entityManager.find(e, key);
	}

	@SuppressWarnings("unchecked")
	public List<E> getAll() throws DataAccessException {
		CriteriaQuery<E> cq = (CriteriaQuery<E>) entityManager.getCriteriaBuilder()
				.createQuery();
		cq.select(cq.from(e));
		return entityManager.createQuery(cq).getResultList();
	}

}