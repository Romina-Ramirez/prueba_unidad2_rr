package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
		this.entityManager.remove(this.leer(id));
	}

	@Override
	public Doctor leerPorCedula(String cedula) {
		TypedQuery<Doctor> myQuery = this.entityManager
				.createQuery("SELECT d FROM Doctor d WHERE d.cedula = :datoCedula", Doctor.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

}
