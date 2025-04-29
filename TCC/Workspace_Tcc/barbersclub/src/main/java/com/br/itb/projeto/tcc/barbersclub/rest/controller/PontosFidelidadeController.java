package com.br.itb.projeto.tcc.barbersclub.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.itb.projeto.tcc.barbersclub.model.entity.PontosFidelidade;
import com.br.itb.projeto.tcc.barbersclub.rest.exception.ResourceNotFoundException;
import com.br.itb.projeto.tcc.barbersclub.service.PontosFidelidadeService;

@RestController
@RequestMapping("/pontosFidelidade")
public class PontosFidelidadeController {

	private PontosFidelidadeService pontosFidelidadeService;
	// Source => Generate Constructor using Fields...

	public PontosFidelidadeController(PontosFidelidadeService pontosFidelidadeService) {
		super();
		this.pontosFidelidadeService = pontosFidelidadeService;
	}
	
	@GetMapping("/test")
	public String getTest() {
		return "Olá, PontosFidelidade!";
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<PontosFidelidade> findById(@PathVariable Long id) {
		
		PontosFidelidade pontosFidelidade = pontosFidelidadeService.findById(id);
		if(pontosFidelidade != null) {
			return new ResponseEntity<PontosFidelidade>(pontosFidelidade, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("PontosFidelidade não encontrado!");
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<PontosFidelidade>> findAll() {
		List<PontosFidelidade> pontosFidelidades = pontosFidelidadeService.findAll();
		return new ResponseEntity<List<PontosFidelidade>>(pontosFidelidades, HttpStatus.OK);
	}
	
}
