package com.pizza.delivery.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the INGREDIENT database table.
 * 
 */
@Entity
@Table(name="INGREDIENT")
@NamedQuery(name="Ingredient.findAll", query="SELECT i FROM Ingredient i")
public class Ingredient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INGREDIENT_INGREDIENTID_GENERATOR", sequenceName="INGREDIENT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INGREDIENT_INGREDIENTID_GENERATOR")
	@Column(name="INGREDIENT_ID", unique=true, nullable=false)
	private long ingredientId;

	@Column(nullable=false, length=20)
	private String name;

	@Column(nullable=false, precision=126)
	private double price;

	@Column(name="\"TYPE\"", nullable=false, length=20)
	private String type;

	//bi-directional many-to-one association to Pizza
	@OneToMany(mappedBy="ingredient")
	private List<Pizza> pizzas;

	public Ingredient() {
	}

	public long getIngredientId() {
		return this.ingredientId;
	}

	public void setIngredientId(long ingredientId) {
		this.ingredientId = ingredientId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Pizza> getPizzas() {
		return this.pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public Pizza addPizza(Pizza pizza) {
		getPizzas().add(pizza);
		pizza.setIngredient(this);

		return pizza;
	}

	public Pizza removePizza(Pizza pizza) {
		getPizzas().remove(pizza);
		pizza.setIngredient(null);

		return pizza;
	}

}