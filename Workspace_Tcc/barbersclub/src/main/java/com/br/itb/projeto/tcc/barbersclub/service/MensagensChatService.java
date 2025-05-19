package com.br.itb.projeto.tcc.barbersclub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.itb.projeto.tcc.barbersclub.model.entity.MensagensChat;
import com.br.itb.projeto.tcc.barbersclub.model.repository.MensagensChatRepository;

import jakarta.transaction.Transactional;


@Service
public class MensagensChatService {
	
	private MensagensChatRepository mensagensChatRepository;
	// Source => Generate Constructor using Fields...

	public MensagensChatService(MensagensChatRepository mensagensChatRepository) {
		super();
		this.mensagensChatRepository = mensagensChatRepository;
	}
	
	public MensagensChat findById(Long id) {
		Optional<MensagensChat> mensagensChat = mensagensChatRepository.findById(id);
	if(mensagensChat.isPresent()) {
		return mensagensChat.get();
		}
	return null;
	}
	
	public List<MensagensChat> findAll(){
		List<MensagensChat> mensagensChats = mensagensChatRepository.findAll();
		return mensagensChats;
	}

	@Transactional
	public MensagensChat save(MensagensChat mensagensChat) {
		MensagensChat _mensagensChat = mensagensChatRepository.save(mensagensChat);
		return _mensagensChat;
	}
	
}
