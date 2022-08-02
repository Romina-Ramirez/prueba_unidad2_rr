package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICitaMedicaRepository;
import com.uce.edu.demo.repository.modelo.CitaMedica;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService {

	@Autowired
	private ICitaMedicaRepository citaMedicaRepository;

	@Override
	public void insertar(CitaMedica citaMedica) {
		this.citaMedicaRepository.crear(citaMedica);
	}

}
