package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Doctor;

public interface IDoctorRepository {

	public void crear(Doctor doctor);

	public Doctor leer(Integer id);

	public void actualizar(Doctor doctor);

	public void eliminar(Integer id);

	public Doctor leerPorCedula(String cedula);

}
