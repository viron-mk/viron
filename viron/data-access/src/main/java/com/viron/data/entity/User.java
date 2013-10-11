package com.viron.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the "OWNER" database table.
 * 
 */
@Entity
@Table(name = "\"USER\"")
@NamedQueries({
		@NamedQuery(name = "FIND_ALL_USERS", query = "SELECT user FROM User user"),
		@NamedQuery(name = "FIND_USERS_LIKE", query = "SELECT user FROM User user WHERE"
				+ " user.id = :id OR user.address = :address OR user.city = :city OR user.country = :country"
				+ " OR user.middleName = :middleName OR user.name = :name OR user.surname = :surname"
				+ " OR user.type = :type OR user.gender = :gender") })
public class User implements IEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "USER_ID_GENERATOR", sequenceName = "VIRONSEQUENCE", allocationSize=1)
	@GeneratedValue(generator = "USER_ID_GENERATOR")
	@Column(name = "\"ID\"", unique = true, nullable = false, length = 13)
	private Integer id;

	@Column(name = "\"ADDRESS\"", nullable = false, length = 40)
	private String address;

	@Column(name = "\"CITY\"", nullable = false, length = 20)
	private String city;

	@Column(name = "\"COUNTRY\"", length = 20)
	private String country;

	@Column(name = "\"MIDDLE_NAME\"", length = 20)
	private String middleName;

	@Column(name = "\"NAME\"", nullable = false, length = 20)
	private String name;

	@Column(name = "\"SURNAME\"", nullable = false, length = 20)
	private String surname;

	@Column(name = "\"TYPE\"", nullable = false, length = 20)
	private String type;

	@Column(name = "\"GENDER\"", nullable = false, length = 20)
	private String gender;

	public User() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

}