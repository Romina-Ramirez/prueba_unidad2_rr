package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteSencillo;

public interface IPacienteRepository {

	public void crear(Paciente paciente);

	public Paciente leer(Integer id);

	public void actualizar(Paciente paciente);

	public void eliminar(Integer id);

	public Paciente leerPorCedula(String cedula);

	public List<PacienteSencillo> leerPorFechaNacimientoGenero(LocalDateTime fecha, String genero);

}
