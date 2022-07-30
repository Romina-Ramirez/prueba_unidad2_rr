package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Doctor;

public interface IDoctorRepository {

	public void crear(Doctor doctor);

	public Doctor leer(Integer id);

	public void actualizar(Doctor doctor);

	public void eliminar(Integer id);

	// Adicionales al CRUD
	// Usado para la funcionalidad 3 para buscar un doctor por cedula
	public Doctor leerPorCedula(String cedula);

}
