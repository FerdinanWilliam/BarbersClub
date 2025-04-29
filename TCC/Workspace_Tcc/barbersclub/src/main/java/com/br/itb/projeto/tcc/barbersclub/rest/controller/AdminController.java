package com.br.itb.projeto.tcc.barbersclub.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.itb.projeto.tcc.barbersclub.model.entity.Admin;
import com.br.itb.projeto.tcc.barbersclub.rest.exception.ResourceNotFoundException;
import com.br.itb.projeto.tcc.barbersclub.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	private AdminService adminService;
	// Source => Generate Constructor using Fields...

	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	@GetMapping("/test")
	public String getTest() {
		return "Olá, Admin!";
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Admin> findById(@PathVariable Long id) {
		
		Admin admin = adminService.findById(id);
		if(admin != null) {
			return new ResponseEntity<Admin>(admin, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("Admin não encontrado!");
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Admin>> findAll() {
		List<Admin> admins = adminService.findAll();
		return new ResponseEntity<List<Admin>>(admins, HttpStatus.OK);
	}
	
}
