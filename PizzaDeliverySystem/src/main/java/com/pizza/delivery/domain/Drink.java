package com.pizza.delivery.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRINK database table.
 * 
 */
@Entity
@Table(name="DRINK")
@NamedQuery(name="Drink.findAll", query="SELECT d FROM Drink d")
public class Drink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DRINK_DRINKID_GENERATOR", sequenceName="DRINK_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DRINK_DRINKID_GENERATOR")
	@Column(name="DRINK_ID", unique=true, nullable=false)
	private long drinkId;

	@Column(nullable=false, length=20)
	private String name;

	@Column(nullable=false, precision=126)
	private double price;

	//bi-directional many-to-one association to Ordering
	@OneToMany(mappedBy="drinkBean")
	private List<Ordering> orderings;

	public Drink() {
	}

	public long getDrinkId() {
		return this.drinkId;
	}

	public void setDrinkId(long drinkId) {
		this.drinkId = drinkId;
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

	public List<Ordering> getOrderings() {
		return this.orderings;
	}

	public void setOrderings(List<Ordering> orderings) {
		this.orderings = orderings;
	}

	public Ordering addOrdering(Ordering ordering) {
		getOrderings().add(ordering);
		ordering.setDrinkBean(this);

		return ordering;
	}

	public Ordering removeOrdering(Ordering ordering) {
		getOrderings().remove(ordering);
		ordering.setDrinkBean(null);

		return ordering;
	}

}