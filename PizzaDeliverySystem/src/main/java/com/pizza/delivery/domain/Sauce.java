package com.pizza.delivery.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SAUCE database table.
 * 
 */
@Entity
@Table(name="SAUCE")
@NamedQuery(name="Sauce.findAll", query="SELECT s FROM Sauce s")
public class Sauce implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SAUCE_SAUCEID_GENERATOR", sequenceName="SAUCE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SAUCE_SAUCEID_GENERATOR")
	@Column(name="SAUCE_ID", unique=true, nullable=false)
	private long sauceId;

	@Column(nullable=false, length=20)
	private String name;

	@Column(nullable=false, precision=126)
	private double price;

	//bi-directional many-to-one association to Ordering
	@OneToMany(mappedBy="sauceBean")
	private List<Ordering> orderings;

	public Sauce() {
	}

	public long getSauceId() {
		return this.sauceId;
	}

	public void setSauceId(long sauceId) {
		this.sauceId = sauceId;
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
		ordering.setSauceBean(this);

		return ordering;
	}

	public Ordering removeOrdering(Ordering ordering) {
		getOrderings().remove(ordering);
		ordering.setSauceBean(null);

		return ordering;
	}

}