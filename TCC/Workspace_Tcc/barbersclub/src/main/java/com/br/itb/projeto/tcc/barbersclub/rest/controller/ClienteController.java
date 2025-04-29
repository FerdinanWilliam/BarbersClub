package com.br.itb.projeto.tcc.barbersclub.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.itb.projeto.tcc.barbersclub.model.entity.Cliente;
import com.br.itb.projeto.tcc.barbersclub.rest.exception.ResourceNotFoundException;
import com.br.itb.projeto.tcc.barbersclub.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	private ClienteService clienteService;
	// Source => Generate Constructor using Fields...

	public ClienteController(ClienteService clienteService) {
		super();
		this.clienteService = clienteService;
	}
	
	@GetMapping("/test")
	public String getTest() {
		return "Olá, Cliente!";
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		
		Cliente cliente = clienteService.findById(id);
		if(cliente != null) {
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("Cliente não encontrado!");
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> clientes = clienteService.findAll();
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}
	
}
