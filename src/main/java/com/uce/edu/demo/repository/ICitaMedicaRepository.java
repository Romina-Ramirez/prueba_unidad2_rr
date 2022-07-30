package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.CitaMedica;

public interface ICitaMedicaRepository {

	public void crear(CitaMedica citaMedica);

	public CitaMedica leerPorNumero(String numeroCita);

	public void actualizar(CitaMedica citaMedica);

}
