package com.br.itb.projeto.tcc.barbersclub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.itb.projeto.tcc.barbersclub.model.entity.Barbeiro;
import com.br.itb.projeto.tcc.barbersclub.model.repository.BarbeiroRepository;

import jakarta.transaction.Transactional;


@Service
public class BarbeiroService {
	
	private BarbeiroRepository barbeiroRepository;
	// Source => Generate Constructor using Fields...

	public BarbeiroService(BarbeiroRepository barbeiroRepository) {
		super();
		this.barbeiroRepository = barbeiroRepository;
	}
	
	public Barbeiro findById(Long id) {
		Optional<Barbeiro> barbeiro = barbeiroRepository.findById(id);
	if(barbeiro.isPresent()) {
		return barbeiro.get();
		}
	return null;
	}
	
	public List<Barbeiro> findAll(){
		List<Barbeiro> barbeiros = barbeiroRepository.findAll();
		return barbeiros;
	}
	
	@Transactional
	public Barbeiro save(Barbeiro barbeiro) {
		Barbeiro _barbeiro = barbeiroRepository.save(barbeiro);
		return _barbeiro;
	}

}
