package com.br.itb.projeto.tcc.barbersclub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.itb.projeto.tcc.barbersclub.model.entity.Agendamento;
import com.br.itb.projeto.tcc.barbersclub.model.repository.AgendamentoRepository;


@Service
public class AgendamentoService {
	
	private AgendamentoRepository agendamentoRepository;
	// Source => Generate Constructor using Fields...

	public AgendamentoService(AgendamentoRepository agendamentoRepository) {
		super();
		this.agendamentoRepository = agendamentoRepository;
	}
	
	public Agendamento findById(Long id) {
		Optional<Agendamento> agendamento = agendamentoRepository.findById(id);
	if(agendamento.isPresent()) {
		return agendamento.get();
		}
	return null;
	}
	
	public List<Agendamento> findAll(){
		List<Agendamento> agendamentos = agendamentoRepository.findAll();
		return agendamentos;
	}

}
