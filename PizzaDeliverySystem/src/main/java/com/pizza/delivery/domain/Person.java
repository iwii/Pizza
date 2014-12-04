package com.pizza.delivery.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PERSON database table.
 * 
 */
@Entity
@Table(name="PERSON")
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSON_PERSONID_GENERATOR", sequenceName="PERSON_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSON_PERSONID_GENERATOR")
	@Column(name="PERSON_ID", unique=true, nullable=false)
	private long personId;

	@Column(length=20)
	private String city;

	@Column(name="FIRST_NAME", nullable=false, length=20)
	private String firstName;

	@Column(name="LAST_NAME", length=20)
	private String lastName;

	@Column(length=20)
	private String status;

	@Column(length=20)
	private String street;

	@Column(unique=true, length=20)
	private String telephone;

	@Column(length=20)
	private String zipcode;

	//bi-directional many-to-one association to Ordering
	@OneToMany(mappedBy="personBean")
	private List<Ordering> orderings;

	public Person() {
	}

	public long getPersonId() {
		return this.personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public List<Ordering> getOrderings() {
		return this.orderings;
	}

	public void setOrderings(List<Ordering> orderings) {
		this.orderings = orderings;
	}

	public Ordering addOrdering(Ordering ordering) {
		getOrderings().add(ordering);
		ordering.setPersonBean(this);

		return ordering;
	}

	public Ordering removeOrdering(Ordering ordering) {
		getOrderings().remove(ordering);
		ordering.setPersonBean(null);

		return ordering;
	}

}