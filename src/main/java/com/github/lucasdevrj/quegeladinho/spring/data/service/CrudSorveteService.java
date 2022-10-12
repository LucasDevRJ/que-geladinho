package com.github.lucasdevrj.quegeladinho.spring.data.service;

import org.springframework.stereotype.Service;

import com.github.lucasdevrj.quegeladinho.spring.data.repository.SorveteRepository;

@Service
public class CrudSorveteService {

	private final SorveteRepository sorveteRepository;

	public CrudSorveteService(SorveteRepository sorveteRepository) {
		this.sorveteRepository = sorveteRepository;
	}
	
	public void inicial() {
		
	}
	
	public void salvar() {
		
	}
}
