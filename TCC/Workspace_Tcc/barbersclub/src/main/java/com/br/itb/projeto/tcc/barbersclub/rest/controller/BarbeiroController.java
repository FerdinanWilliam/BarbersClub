package com.br.itb.projeto.tcc.barbersclub.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.itb.projeto.tcc.barbersclub.model.entity.Barbeiro;
import com.br.itb.projeto.tcc.barbersclub.rest.exception.ResourceNotFoundException;
import com.br.itb.projeto.tcc.barbersclub.service.BarbeiroService;

@RestController
@RequestMapping("/barbeiro")
public class BarbeiroController {

	private BarbeiroService barbeiroService;
	// Source => Generate Constructor using Fields...

	public BarbeiroController(BarbeiroService barbeiroService) {
		super();
		this.barbeiroService = barbeiroService;
	}
	
	@GetMapping("/test")
	public String getTest() {
		return "Olá, Barbeiro!";
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Barbeiro> findById(@PathVariable Long id) {
		
		Barbeiro barbeiro = barbeiroService.findById(id);
		if(barbeiro != null) {
			return new ResponseEntity<Barbeiro>(barbeiro, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("Barbeiro não encontrado!");
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Barbeiro>> findAll() {
		List<Barbeiro> barbeiros = barbeiroService.findAll();
		return new ResponseEntity<List<Barbeiro>>(barbeiros, HttpStatus.OK);
	}
	
}
