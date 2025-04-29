package com.br.itb.projeto.tcc.barbersclub.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.itb.projeto.tcc.barbersclub.model.entity.Barbearia;
import com.br.itb.projeto.tcc.barbersclub.rest.exception.ResourceNotFoundException;
import com.br.itb.projeto.tcc.barbersclub.service.BarbeariaService;

@RestController
@RequestMapping("/barbearia")
public class BarbeariaController {

	private BarbeariaService barbeariaService;
	// Source => Generate Constructor using Fields...

	public BarbeariaController(BarbeariaService barbeariaService) {
		super();
		this.barbeariaService = barbeariaService;
	}
	
	@GetMapping("/test")
	public String getTest() {
		return "Olá, Barbearia!";
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Barbearia> findById(@PathVariable Long id) {
		
		Barbearia barbearia = barbeariaService.findById(id);
		if(barbearia != null) {
			return new ResponseEntity<Barbearia>(barbearia, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("Barbearia não encontrada!");
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Barbearia>> findAll() {
		List<Barbearia> barbearias = barbeariaService.findAll();
		return new ResponseEntity<List<Barbearia>>(barbearias, HttpStatus.OK);
	}
	
}
