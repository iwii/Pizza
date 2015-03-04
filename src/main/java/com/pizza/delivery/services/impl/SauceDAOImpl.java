package com.pizza.delivery.services.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.pizza.delivery.domain.Sauce;
import com.pizza.delivery.services.SauceDAO;

@Repository
public class SauceDAOImpl extends AbstractDAOImpl<Sauce, Long>
implements SauceDAO<Sauce> {
	@Override
		public List<Sauce> findByName(String name) {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Sauce> query = cb.createQuery(Sauce.class);
			Root<Sauce> c = query.from(Sauce.class);

			ParameterExpression<String> nameParam = cb.parameter(String.class,
					"name");
			query.select(c).where(cb.equal(c.get("name"), nameParam));

			TypedQuery<Sauce> typedQuery = entityManager.createQuery(query);
			typedQuery.setParameter("name", name);
			return typedQuery.getResultList();
		}
}
