package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.CitaMedica;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(CitaMedica citaMedica) {
		this.entityManager.persist(citaMedica);
	}

	@Override
	public CitaMedica leerPorNumero(String numeroCita) {
		TypedQuery<CitaMedica> myQuery = this.entityManager
				.createQuery("SELECT c FROM CitaMedica c WHERE c.numeroCita = :numeroCita", CitaMedica.class);
		myQuery.setParameter("numeroCita", numeroCita);
		return myQuery.getSingleResult();
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		this.entityManager.merge(citaMedica);
	}

}
