package com.br.itb.projeto.tcc.barbersclub.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MensagensChat")
public class MensagensChat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String mensagem;
	private boolean lida;
	private boolean mensagemBot;
	private LocalDateTime iniciadoEm;
	private long remetente_id;
	private long destinatario_id;
	
	@ManyToOne
	@JoinColumn(name = "remetente_id", insertable=false, updatable=false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "destinatario_id", insertable=false, updatable=false)
	private Admin admin;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public boolean isLida() {
		return lida;
	}

	public void setLida(boolean lida) {
		this.lida = lida;
	}

	public boolean isMensagemBot() {
		return mensagemBot;
	}

	public void setMensagemBot(boolean mensagemBot) {
		this.mensagemBot = mensagemBot;
	}

	public LocalDateTime getIniciadoEm() {
		return iniciadoEm;
	}

	public void setIniciadoEm(LocalDateTime iniciadoEm) {
		this.iniciadoEm = iniciadoEm;
	}

	public long getRemetente_id() {
		return remetente_id;
	}

	public void setRemetente_id(long remetente_id) {
		this.remetente_id = remetente_id;
	}
	
	public long getDestinatario_id() {
		return destinatario_id;
	}

	public void setDestinatario_id(long destinatario_id) {
		this.destinatario_id = destinatario_id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
}
