package com.br.itb.projeto.tcc.barbersclub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.itb.projeto.tcc.barbersclub.model.entity.Cliente;
import com.br.itb.projeto.tcc.barbersclub.model.repository.ClienteRepository;

import jakarta.transaction.Transactional;


@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;
	// Source => Generate Constructor using Fields...

	public ClienteService(ClienteRepository clienteRepository) {
		super();
		this.clienteRepository = clienteRepository;
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
	if(cliente.isPresent()) {
		return cliente.get();
		}
	return null;
	}
	
	public List<Cliente> findAll(){
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes;
	}

	@Transactional
	public Cliente save(Cliente cliente) {
		Cliente _cliente = clienteRepository.save(cliente);
		return _cliente;
	}
	
}
