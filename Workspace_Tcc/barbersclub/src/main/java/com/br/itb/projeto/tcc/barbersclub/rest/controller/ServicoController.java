package com.br.itb.projeto.tcc.barbersclub.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.itb.projeto.tcc.barbersclub.model.entity.Servico;
import com.br.itb.projeto.tcc.barbersclub.rest.exception.ResourceNotFoundException;
import com.br.itb.projeto.tcc.barbersclub.service.ServicoService;

@RestController
@RequestMapping("/servico")
public class ServicoController {

	private ServicoService servicoService;
	// Source => Generate Constructor using Fields...

	public ServicoController(ServicoService servicoService) {
		super();
		this.servicoService = servicoService;
	}
	
	@GetMapping("/test")
	public String getTest() {
		return "Olá, Servico!";
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Servico> findById(@PathVariable Long id) {
		
		Servico servico = servicoService.findById(id);
		if(servico != null) {
			return new ResponseEntity<Servico>(servico, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("Servico não encontrado!");
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Servico>> findAll() {
		List<Servico> servicos = servicoService.findAll();
		return new ResponseEntity<List<Servico>>(servicos, HttpStatus.OK);
	}
	
}
