package com.br.itb.projeto.tcc.barbersclub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.itb.projeto.tcc.barbersclub.model.entity.Servico;
import com.br.itb.projeto.tcc.barbersclub.model.repository.ServicoRepository;

import jakarta.transaction.Transactional;


@Service
public class ServicoService {
	
	private ServicoRepository servicoRepository;
	// Source => Generate Constructor using Fields...

	public ServicoService(ServicoRepository servicoRepository) {
		super();
		this.servicoRepository = servicoRepository;
	}
	
	public Servico findById(Long id) {
		Optional<Servico> servico = servicoRepository.findById(id);
	if(servico.isPresent()) {
		return servico.get();
		}
	return null;
	}
	
	public List<Servico> findAll(){
		List<Servico> servicos = servicoRepository.findAll();
		return servicos;
	}
	
	@Transactional
	public Servico save(Servico servico) {
		Servico _servico = servicoRepository.save(servico);
		return _servico;
	}

}
