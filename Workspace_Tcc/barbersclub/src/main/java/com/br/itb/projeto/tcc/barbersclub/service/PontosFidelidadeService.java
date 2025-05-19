package com.br.itb.projeto.tcc.barbersclub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.itb.projeto.tcc.barbersclub.model.entity.PontosFidelidade;
import com.br.itb.projeto.tcc.barbersclub.model.repository.PontosFidelidadeRepository;

import jakarta.transaction.Transactional;


@Service
public class PontosFidelidadeService {
	
	private PontosFidelidadeRepository pontosFidelidadeRepository;
	// Source => Generate Constructor using Fields...

	public PontosFidelidadeService(PontosFidelidadeRepository pontosFidelidadeRepository) {
		super();
		this.pontosFidelidadeRepository = pontosFidelidadeRepository;
	}
	
	public PontosFidelidade findById(Long id) {
		Optional<PontosFidelidade> pontosFidelidade = pontosFidelidadeRepository.findById(id);
	if(pontosFidelidade.isPresent()) {
		return pontosFidelidade.get();
		}
	return null;
	}
	
	public List<PontosFidelidade> findAll(){
		List<PontosFidelidade> pontosFidelidades = pontosFidelidadeRepository.findAll();
		return pontosFidelidades;
	}
	
	@Transactional
	public PontosFidelidade save(PontosFidelidade pontosFidelidade) {
		PontosFidelidade _pontosFidelidade = pontosFidelidadeRepository.save(pontosFidelidade);
		return _pontosFidelidade;
	}

}
