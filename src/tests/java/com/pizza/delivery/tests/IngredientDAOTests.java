package com.pizza.delivery.tests;

//import static org.springframework.util.Assert.notNull;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pizza.delivery.domain.Ingredient;
import com.pizza.delivery.services.IngredientDAO;

//import com.pizza.delivery.services.impl.IngredientDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "testApplicationContext.xml" })
public class IngredientDAOTests {

	@Autowired
	private IngredientDAO<Ingredient> ingredientDAO;
	private Ingredient ingredient;

	private static final String IngredientTestName = "PepperTestXXXX";

	@Before
	public void setUp() {
		ingredient = new Ingredient();
		ingredient.setName(IngredientTestName);
		ingredient.setPrice(2.0);
		ingredient = ingredientDAO.create(ingredient);
	}

	@After
	public void afterTests() {
		ingredientDAO.delete(ingredient.getIngredientId());
	}

	@Test
	public void findByNameTest() {
		List<Ingredient> listFindByName = ingredientDAO
				.findByName(IngredientTestName);
		assertNotNull(listFindByName);
		assertEquals(listFindByName.size(), 1);
		Ingredient ingredientToCompare = listFindByName.get(0);
		assertEquals(ingredientToCompare.getName(), ingredient.getName());
		assertEquals(ingredientToCompare.getPrice(), ingredient.getPrice());
	}
}
