package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.PacienteSencillo;

public interface IGestorCitaMedicaService {

	public void agendarCita(String numero, LocalDateTime fecha, BigDecimal valor, String lugar, String cedulaDoctor,
			String cedulaPaciente);

	public void actualizarCita(String numero, String diagnostico, String receta, LocalDateTime fechaProxima);

	public List<PacienteSencillo> reportePacientes(LocalDateTime fecha, String genero);
}
