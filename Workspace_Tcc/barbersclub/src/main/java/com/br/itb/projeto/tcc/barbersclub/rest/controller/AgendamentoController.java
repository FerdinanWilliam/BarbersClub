package com.br.itb.projeto.tcc.barbersclub.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.itb.projeto.tcc.barbersclub.model.entity.Agendamento;
import com.br.itb.projeto.tcc.barbersclub.rest.exception.ResourceNotFoundException;
import com.br.itb.projeto.tcc.barbersclub.service.AgendamentoService;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

	private AgendamentoService agendamentoService;
	// Source => Generate Constructor using Fields...

	public AgendamentoController(AgendamentoService agendamentoService) {
		super();
		this.agendamentoService = agendamentoService;
	}
	
	@GetMapping("/test")
	public String getTest() {
		return "Olá, Agendamento!";
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Agendamento> findById(@PathVariable Long id) {
		
		Agendamento agendamento = agendamentoService.findById(id);
		if(agendamento != null) {
			return new ResponseEntity<Agendamento>(agendamento, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("Agendamento não encontrado!");
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Agendamento>> findAll() {
		List<Agendamento> agendamentos = agendamentoService.findAll();
		return new ResponseEntity<List<Agendamento>>(agendamentos, HttpStatus.OK);
	}
	
}
