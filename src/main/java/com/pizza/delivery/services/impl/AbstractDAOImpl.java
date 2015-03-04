package com.pizza.delivery.services.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	protected Class<E> entityClazz;

	@SuppressWarnings("unchecked")
	public AbstractDAOImpl() {
		entityClazz = (Class<E>) ((ParameterizedType) (getClass().getGenericSuperclass()))
				.getActualTypeArguments()[0];
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	
	public void setEntityManager(EntityManager entity) {
		this.entityManager = entity;
	}

	// /////////////////////////////Create///////////////////////////////////////
	@Override
	public E create(E entity) {
		this.entityManager.persist(entity);
		this.entityManager.flush();
		//this.entityManager.merge(entity);
		return entity;
	}

	// /////////////////////////////Update/////////////////////////////////////
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public E update(E entity) {
		
		E result = this.entityManager.merge(entity);
		entityManager.flush();
		return result;
	}

	// ////////////////////////Delete//////////////////////////////////////////
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = IllegalArgumentException.class ,noRollbackFor = IllegalArgumentException.class)
	public void delete(K key) {
		E entity = entityManager.find(entityClazz,key);		
			this.entityManager.remove(entity);
		
	}

	// /////////////////////////////FindById///////////////////////////////////
	@Override
	public E findById(K key) {
		return entityManager.find(entityClazz, key);
	}
	
	@SuppressWarnings("unchecked")
	public List<E> listAll() {
		final Session session = (Session) entityManager.getDelegate();
		final Criteria crit = session.createCriteria(entityClazz);
		return crit.list();
	}

}