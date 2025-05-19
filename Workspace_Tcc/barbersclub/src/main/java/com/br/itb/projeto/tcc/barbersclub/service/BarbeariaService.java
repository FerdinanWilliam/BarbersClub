package com.br.itb.projeto.tcc.barbersclub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.itb.projeto.tcc.barbersclub.model.entity.Barbearia;
import com.br.itb.projeto.tcc.barbersclub.model.repository.BarbeariaRepository;

import jakarta.transaction.Transactional;


@Service
public class BarbeariaService {
	
	private BarbeariaRepository barbeariaRepository;
	// Source => Generate Constructor using Fields...

	public BarbeariaService(BarbeariaRepository barbeariaRepository) {
		super();
		this.barbeariaRepository = barbeariaRepository;
	}
	
	public Barbearia findById(Long id) {
		Optional<Barbearia> barbearia = barbeariaRepository.findById(id);
	if(barbearia.isPresent()) {
		return barbearia.get();
		}
	return null;
	}
	
	public List<Barbearia> findAll(){
		List<Barbearia> barbearias = barbeariaRepository.findAll();
		return barbearias;
	}
	
	@Transactional
	public Barbearia save(Barbearia barbearia) {
		Barbearia _barbearia = barbeariaRepository.save(barbearia);
		return _barbearia;
	}

}
