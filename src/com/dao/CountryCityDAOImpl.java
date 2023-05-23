package com.dao;

import java.util.List;

import com.entity.City;
import com.entity.Country;
import com.provider.ProviderManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.RollbackException;

//la classe implementa tutte le operazioi di crud definite all'interno dell'interfaccia
public class CountryCityDAOImpl implements CountryCityDAO {

//	utilizziamo i metodi initRoutine e closeRoutine per avviare e chiudere le transazioni

	private EntityManagerFactory emf;
	private EntityManager em;

//	implementazione delle operazioni di crud

	@Override
	public void insertCityCountry(Country country, List<City> city) {
		initRoutine();
		city.forEach(c -> c.setCountry(country));
		country.setCity(city);
		em.persist(country);
		closeRoutine();
	}

	@Override
	public void updateCountry(Country country) {
		initRoutine();
		em.merge(country);
		closeRoutine();
	}

	@Override
	public void removeCountry(int CountryId) {
		initRoutine();
		em.remove(em.find(Country.class, CountryId));
		closeRoutine();

	}

	@Override
	public City getCity(int cityId) {

		return null;
	}

//	metodi delle transazioni
	private void initRoutine() {
		emf = ProviderManager.getEntityManagerFactory();
		em = ProviderManager.getEntityManager(emf);
		ProviderManager.beginTransaction(em);
	}

	private void closeRoutine() {
		try {
			ProviderManager.commitTransaction(em);
		} catch (RollbackException rbe) {
			System.err.println("Transazione fallita: eseguo il rollback.");
			rbe.printStackTrace();
			ProviderManager.rollbackTransaction(em);
		} finally {
			ProviderManager.closeTransaction(em);
			ProviderManager.closeEntityManagerFactory(emf);
		}
	}

}
