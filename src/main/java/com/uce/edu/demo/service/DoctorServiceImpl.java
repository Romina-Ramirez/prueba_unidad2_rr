package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IDoctorRepository;
import com.uce.edu.demo.repository.modelo.Doctor;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepository iDoctorRepository;

	@Override
	public void insertar(Doctor doctor) {
		this.iDoctorRepository.crear(doctor);
	}

	@Override
	public Doctor buscar(Integer id) {
		return this.iDoctorRepository.leer(id);
	}

	@Override
	public void actualizar(Doctor doctor) {
		this.iDoctorRepository.actualizar(doctor);
	}

	@Override
	public void eliminar(Integer id) {
		this.iDoctorRepository.eliminar(id);
	}

}
