package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Doctor;

@Repository
@Transactional
public class DoctorRepositoryImpl implements IDoctorRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(Doctor doctor) {
		this.entityManager.persist(doctor);
	}

	@Override
	public Doctor leer(Integer id) {
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	public void actualizar(Doctor doctor) {
		this.entityManager.merge(doctor);
	}

	@Override
	public void eliminar(Integer id) {
		Doctor doctor = this.leer(id);
		this.entityManager.remove(doctor);
	}

	@Override
	public Doctor leerPorCedula(String cedula) {
		Query jpqlQuery = this.entityManager.createQuery("SELECT d FROM Doctor d WHERE d.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		return (Doctor) jpqlQuery.getSingleResult();
	}

}
