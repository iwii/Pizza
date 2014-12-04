package com.pizza.delivery.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ORDERING database table.
 * 
 */
@Entity
@Table(name="ORDERING")
@NamedQuery(name="Ordering.findAll", query="SELECT o FROM Ordering o")
public class Ordering implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORDERING_ORDERINGID_GENERATOR", sequenceName="ORDERING_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORDERING_ORDERINGID_GENERATOR")
	@Column(name="ORDERING_ID", unique=true, nullable=false)
	private long orderingId;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_ORDER", nullable=false)
	private Date dateOfOrder;

	@Column(nullable=false, precision=126)
	private double price;

	@Column(nullable=false, length=20)
	private String status;

	//bi-directional many-to-one association to Drink
	@ManyToOne
	@JoinColumn(name="DRINK")
	private Drink drinkBean;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="PERSON", nullable=false)
	private Person personBean;

	//bi-directional many-to-one association to Pizza
	@ManyToOne
	@JoinColumn(name="PIZZA")
	private Pizza pizzaBean;

	//bi-directional many-to-one association to Sauce
	@ManyToOne
	@JoinColumn(name="SAUCE")
	private Sauce sauceBean;

	public Ordering() {
	}

	public long getOrderingId() {
		return this.orderingId;
	}

	public void setOrderingId(long orderingId) {
		this.orderingId = orderingId;
	}

	public Date getDateOfOrder() {
		return this.dateOfOrder;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Drink getDrinkBean() {
		return this.drinkBean;
	}

	public void setDrinkBean(Drink drinkBean) {
		this.drinkBean = drinkBean;
	}

	public Person getPersonBean() {
		return this.personBean;
	}

	public void setPersonBean(Person personBean) {
		this.personBean = personBean;
	}

	public Pizza getPizzaBean() {
		return this.pizzaBean;
	}

	public void setPizzaBean(Pizza pizzaBean) {
		this.pizzaBean = pizzaBean;
	}

	public Sauce getSauceBean() {
		return this.sauceBean;
	}

	public void setSauceBean(Sauce sauceBean) {
		this.sauceBean = sauceBean;
	}

}