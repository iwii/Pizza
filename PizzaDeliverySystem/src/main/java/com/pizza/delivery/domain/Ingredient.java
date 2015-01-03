package com.pizza.delivery.domain;

import java.io.Serializable;
import javax.persistence.*;


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
	@Column(name="INGREDIENT_ID", unique=true, nullable=false, precision=19)
	private long ingredientId;

	@Column(nullable=false, length=20)
	private String name;

	@Column(nullable=false, precision=126)
	private double price;

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

}