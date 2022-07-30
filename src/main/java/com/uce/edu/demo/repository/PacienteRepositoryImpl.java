package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteSencillo;

@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(Paciente paciente) {
		this.entityManager.persist(paciente);
	}

	@Override
	public Paciente leer(Integer id) {
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void actualizar(Paciente paciente) {
		this.entityManager.merge(paciente);
	}

	@Override
	public void eliminar(Integer id) {
		Paciente paciente = this.leer(id);
		this.entityManager.remove(paciente);
	}

	@Override
	public Paciente leerPorCedula(String cedula) {
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Paciente p WHERE p.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		return (Paciente) jpqlQuery.getSingleResult();
	}

	@Override
	public List<PacienteSencillo> leerPorFechaNacimientoGenero(LocalDateTime fecha, String genero) {
		TypedQuery<PacienteSencillo> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.PacienteSencillo(p.cedula, p.nombre, p.fechaNacimiento, p.genero) FROM Paciente p WHERE p.fechaNacimiento > :fecha AND p.genero = :genero",
				PacienteSencillo.class);
		myQuery.setParameter("fecha", fecha);
		myQuery.setParameter("genero", genero);
		return myQuery.getResultList();
	}

}
