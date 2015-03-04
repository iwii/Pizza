package com.pizza.delivery.domain;

import java.io.Serializable;
import javax.persistence.*;


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
	@Column(name="PERSON_ID", unique=true, nullable=false, precision=19)
	private long personId;

	@Column(nullable=false, length=20)
	private String city;

	@Column(nullable=false, length=20)
	private String email;

	@Column(name="FIRST_NAME", nullable=false, length=20)
	private String firstName;

	@Column(name="LAST_NAME", nullable=false, length=30)
	private String lastName;

	@Column(nullable=false, length=20)
	private String login;

	@Column(nullable=false, length=20)
	private String password;

	@Column(nullable=false, length=20)
	private String status;

	@Column(nullable=false, length=30)
	private String street;

	@Column(unique=true, nullable=false, length=9)
	private String telephone;

	@Column(length=6)
	private String zipcode;

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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

}