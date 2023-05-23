package com.main;

import java.util.ArrayList;
import java.util.List;

import com.dao.CountryCityDAO;
import com.dao.CountryCityDAOImpl;
import com.entity.City;
import com.entity.Country;

public class Main {

	public static void main(String[] args) {

		// istanza dell'interfaccia
		CountryCityDAO dao = new CountryCityDAOImpl();

		Country Puglia = new Country("Puglia");

		List<City> city = new ArrayList<>();

		City Vieste = new City("Vieste");

		city.add(Vieste);

		dao.insertCityCountry(Puglia, city);

		Puglia = new Country("Puglia");
		dao.updateCountry(Puglia);

		dao.removeCountry(122);
	}

}
