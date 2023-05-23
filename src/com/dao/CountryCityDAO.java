package com.dao;

import java.util.List;

import com.entity.City;
import com.entity.Country;

public interface CountryCityDAO {

	public void insertCityCountry(Country country, List<City> city);

	public void updateCountry(Country country);

	public void removeCountry(int CountryId);

//	public Country getCountry(int CountryId);

	public City getCity(int cityId);

}
