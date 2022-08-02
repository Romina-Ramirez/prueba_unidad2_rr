package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICitaMedicaRepository;
import com.uce.edu.demo.repository.IDoctorRepository;
import com.uce.edu.demo.repository.IPacienteRepository;
import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteSencillo;

@Service
public class GestorCitaMedicaServiceImpl implements IGestorCitaMedicaService {

	@Autowired
	private IDoctorRepository doctorRepository;

	@Autowired
	private IPacienteRepository pacienteRepository;

	@Autowired
	private ICitaMedicaRepository citaMedicaRepository;

	@Autowired
	private ICitaMedicaService citaMedicaService;

	@Override
	public void agendarCita(String numero, LocalDateTime fecha, BigDecimal valor, String lugar, String cedulaDoctor,
			String cedulaPaciente) {

		Doctor doctor = this.doctorRepository.leerPorCedula(cedulaDoctor);
		Paciente paciente = this.pacienteRepository.leerPorCedula(cedulaPaciente);

		CitaMedica cita = new CitaMedica();
		cita.setNumeroCita(numero);
		cita.setFechaCita(fecha);
		cita.setValorCita(valor);
		cita.setLugarCita(lugar);
		cita.setDoctor(doctor);
		cita.setPaciente(paciente);

		this.citaMedicaService.insertar(cita);
	}

	@Override
	public void actualizarCita(String numero, String diagnostico, String receta, LocalDateTime fechaProxima) {
		CitaMedica citaMedica = this.citaMedicaRepository.leerPorNumero(numero);

		citaMedica.setDiagnostico(diagnostico);
		citaMedica.setReceta(receta);
		citaMedica.setFechaProximaCita(fechaProxima);

		this.citaMedicaRepository.actualizar(citaMedica);
	}

	@Override
	public List<PacienteSencillo> reportePacientes(LocalDateTime fecha, String genero) {
		return this.pacienteRepository.leerPorFechaNacimientoGenero(fecha, genero);
	}

}
