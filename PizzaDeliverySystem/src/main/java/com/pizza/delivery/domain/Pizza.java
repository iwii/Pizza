package com.pizza.delivery.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PIZZA database table.
 * 
 */
@Entity
@Table(name="PIZZA")
@NamedQuery(name="Pizza.findAll", query="SELECT p FROM Pizza p")
public class Pizza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PIZZA_PIZZAID_GENERATOR", sequenceName="PIZZA_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PIZZA_PIZZAID_GENERATOR")
	@Column(name="PIZZA_ID", unique=true, nullable=false)
	private long pizzaId;

	@Column(length=20)
	private String name;

	@Column(name="PIZZA_BASE", nullable=false, length=20)
	private String pizzaBase;

	@Column(name="PIZZA_SIZE", nullable=false)
	private BigDecimal pizzaSize;

	@Column(nullable=false, precision=126)
	private double price;

	//bi-directional many-to-one association to Ordering
	@OneToMany(mappedBy="pizzaBean")
	private List<Ordering> orderings;

	//bi-directional many-to-one association to Ingredient
	@ManyToOne
	@JoinColumn(name="INGREDIENTS", nullable=false)
	private Ingredient ingredient;

	public Pizza() {
	}

	public long getPizzaId() {
		return this.pizzaId;
	}

	public void setPizzaId(long pizzaId) {
		this.pizzaId = pizzaId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPizzaBase() {
		return this.pizzaBase;
	}

	public void setPizzaBase(String pizzaBase) {
		this.pizzaBase = pizzaBase;
	}

	public BigDecimal getPizzaSize() {
		return this.pizzaSize;
	}

	public void setPizzaSize(BigDecimal pizzaSize) {
		this.pizzaSize = pizzaSize;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Ordering> getOrderings() {
		return this.orderings;
	}

	public void setOrderings(List<Ordering> orderings) {
		this.orderings = orderings;
	}

	public Ordering addOrdering(Ordering ordering) {
		getOrderings().add(ordering);
		ordering.setPizzaBean(this);

		return ordering;
	}

	public Ordering removeOrdering(Ordering ordering) {
		getOrderings().remove(ordering);
		ordering.setPizzaBean(null);

		return ordering;
	}

	public Ingredient getIngredient() {
		return this.ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

}