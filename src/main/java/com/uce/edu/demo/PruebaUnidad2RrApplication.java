package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteSencillo;
import com.uce.edu.demo.service.IDoctorService;
import com.uce.edu.demo.service.IGestorCitaMedicaService;
import com.uce.edu.demo.service.IPacienteService;

@SpringBootApplication
public class PruebaUnidad2RrApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(PruebaUnidad2RrApplication.class);

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private IPacienteService pacienteService;

	@Autowired
	private IGestorCitaMedicaService citaMedicaService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Inserción de los 2 doctores
		Doctor doctor1 = new Doctor();
		doctor1.setCedula("1725365478");
		doctor1.setNombre("Romina");
		doctor1.setApellido("Ramírez");
		doctor1.setFechaNacimiento(LocalDateTime.of(2001, 12, 12, 4, 35));
		doctor1.setNumeroConsultorio("1234");
		doctor1.setCodigoSenescyt("AAAA");
		doctor1.setGenero("F");
		this.doctorService.insertar(doctor1);

		Doctor doctor2 = new Doctor();
		doctor2.setCedula("1754786958");
		doctor2.setNombre("Luis");
		doctor2.setApellido("Lopez");
		doctor2.setFechaNacimiento(LocalDateTime.of(1989, 3, 16, 12, 22));
		doctor2.setNumeroConsultorio("5248");
		doctor2.setCodigoSenescyt("SDJS");
		doctor2.setGenero("M");
		this.doctorService.insertar(doctor2);

		// Inserción de los 2 pacientes
		Paciente paciente1 = new Paciente();
		paciente1.setCedula("1769874521");
		paciente1.setNombre("Maria");
		paciente1.setApellido("Feijoo");
		paciente1.setFechaNacimiento(LocalDateTime.of(2003, 1, 13, 14, 3));
		paciente1.setCodigoSeguro("123AAA");
		paciente1.setEstatura(1.71);
		paciente1.setPeso(56.5);
		paciente1.setGenero("F");
		this.pacienteService.insertar(paciente1);

		Paciente paciente2 = new Paciente();
		paciente2.setCedula("1744745487");
		paciente2.setNombre("Jorge");
		paciente2.setApellido("Loayza");
		paciente2.setFechaNacimiento(LocalDateTime.of(1960, 7, 1, 5, 55));
		paciente2.setCodigoSeguro("584DHS");
		paciente2.setEstatura(1.65);
		paciente2.setPeso(75.8);
		paciente2.setGenero("M");
		this.pacienteService.insertar(paciente2);

		// Funcionalidad 3. - Agendamiento de citas médicas
		this.citaMedicaService.agendarCita("0001", LocalDateTime.now(), new BigDecimal(12), "Portovelo", "1754786958",
				"1744745487");

		// Funcionalidad 4. - Actualización de cita médica
		this.citaMedicaService.actualizarCita("0001", "Asma", "Antiinflamatorio",
				LocalDateTime.of(2022, 8, 10, 12, 40));

		// Funcionalidad 5. - Reporte de pacientes
		List<PacienteSencillo> pacientes = this.citaMedicaService.reportePacientes(LocalDateTime.of(1980, 12, 1, 12, 0),
				"F");

		for (PacienteSencillo item : pacientes) {
			logger.debug("Paciente: " + item);
		}

	}

}
