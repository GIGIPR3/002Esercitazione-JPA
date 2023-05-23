package com.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	private String country;

	@Id
	@Column(name = "country_id")
	private int countryId;

	@UpdateTimestamp
	@Column(name = "last_update")
	private Timestamp lastUpdate;

//	utilizziamo il metodo cascade per semplificare il codice facendo si che all'eliminazione di una country tutti i figli vengono eliminati

	@OneToMany(mappedBy = "country", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<City> city;

	public Country() {
	}

	public Country(String country) {
		this.country = country;
	}

	public Country(String country, int countryId) {
		this.country = country;
		this.countryId = countryId;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}

	public int getCountryId() {
		return this.countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}