package com.br.itb.projeto.tcc.barbersclub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.itb.projeto.tcc.barbersclub.model.entity.Admin;
import com.br.itb.projeto.tcc.barbersclub.model.repository.AdminRepository;

import jakarta.transaction.Transactional;


@Service
public class AdminService {
	
	private AdminRepository adminRepository;
	// Source => Generate Constructor using Fields...

	public AdminService(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}
	
	public Admin findById(Long id) {
		Optional<Admin> admin = adminRepository.findById(id);
	if(admin.isPresent()) {
		return admin.get();
		}
	return null;
	}
	
	public List<Admin> findAll(){
		List<Admin> admins = adminRepository.findAll();
		return admins;
	}
	
	@Transactional
	public Admin save(Admin admin) {
		Admin _admin = adminRepository.save(admin);
		return _admin;
	}

}
