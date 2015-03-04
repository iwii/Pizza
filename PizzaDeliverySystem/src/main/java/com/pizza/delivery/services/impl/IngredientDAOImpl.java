package com.pizza.delivery.services.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.pizza.delivery.domain.Ingredient;
import com.pizza.delivery.services.IngredientDAO;

@Repository
public class IngredientDAOImpl extends AbstractDAOImpl<Ingredient, Long>
		implements IngredientDAO<Ingredient> {

	@Override
	public List<Ingredient> findByName(String name) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Ingredient> query = cb.createQuery(Ingredient.class);
		Root<Ingredient> c = query.from(Ingredient.class);

		ParameterExpression<String> nameParam = cb.parameter(String.class,
				"name");
		query.select(c).where(cb.equal(c.get("name"), nameParam));

		TypedQuery<Ingredient> typedQuery = entityManager.createQuery(query);
		typedQuery.setParameter("name", name);
		return typedQuery.getResultList();
	}

}
