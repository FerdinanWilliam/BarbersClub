package com.br.itb.projeto.tcc.barbersclub.rest.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.br.itb.projeto.tcc.barbersclub.rest.exception.ResourceNotFoundException;

@ControllerAdvice
public class CustomAdviceHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handlerResourceNotFoundException(ResourceNotFoundException e){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	
	}
}
