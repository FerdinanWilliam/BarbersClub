package com.br.itb.projeto.tcc.barbersclub.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.itb.projeto.tcc.barbersclub.model.entity.MensagensChat;
import com.br.itb.projeto.tcc.barbersclub.rest.exception.ResourceNotFoundException;
import com.br.itb.projeto.tcc.barbersclub.service.MensagensChatService;

@RestController
@RequestMapping("/mensagensChat")
public class MensagensChatController {

	private MensagensChatService mensagensChatService;
	// Source => Generate Constructor using Fields...

	public MensagensChatController(MensagensChatService mensagensChatService) {
		super();
		this.mensagensChatService = mensagensChatService;
	}
	
	@GetMapping("/test")
	public String getTest() {
		return "Olá, MensagensChat!";
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<MensagensChat> findById(@PathVariable Long id) {
		
		MensagensChat mensagensChat = mensagensChatService.findById(id);
		if(mensagensChat != null) {
			return new ResponseEntity<MensagensChat>(mensagensChat, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("MensagensChat não encontrado!");
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<MensagensChat>> findAll() {
		List<MensagensChat> mensagensChats = mensagensChatService.findAll();
		return new ResponseEntity<List<MensagensChat>>(mensagensChats, HttpStatus.OK);
	}
	
}
