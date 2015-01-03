package com.pizza.delivery.services.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.pizza.delivery.domain.Drink;
import com.pizza.delivery.services.DrinkDAO;

@Repository
public class DrinkDAOImpl extends AbstractDAOImpl<Drink, Long>
implements DrinkDAO<Drink> {
	@Override
	public List<Drink> findByName(String name) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Drink> query = cb.createQuery(Drink.class);
		Root<Drink> c = query.from(Drink.class);

		ParameterExpression<String> nameParam = cb.parameter(String.class,
				"name");
		query.select(c).where(cb.equal(c.get("name"), nameParam));

		TypedQuery<Drink> typedQuery = entityManager.createQuery(query);
		typedQuery.setParameter("name", name);
		return typedQuery.getResultList();
	}

}
