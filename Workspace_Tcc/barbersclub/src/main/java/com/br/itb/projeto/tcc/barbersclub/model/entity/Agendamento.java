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
@Table(name = "Agendamento")
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime dataAgendamento;
	private String descricao;
	private LocalDateTime criadoEm;
	private long cliente_id;
	private long barbeiro_id;
	private long servico_id;
	
	// Agendamento <-> Cliente
	@ManyToOne			// 1:N
	@JoinColumn(name = "cliente_id", insertable=false, updatable=false)
	private Cliente cliente;
	
	// Agendamento <-> Barbeiro
	@ManyToOne			// 1:N
	@JoinColumn(name = "barbeiro_id", insertable=false, updatable=false)
	private Barbeiro barbeiro;
	
	// Agendamento <-> Servico
	@ManyToOne			// N:1
	@JoinColumn(name = "servico_id", insertable=false, updatable=false)
	private Servico servico;
	
	private String statusAgendamento;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDateTime dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(LocalDateTime criadoEm) {
		this.criadoEm = criadoEm;
	}

	public long getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(long cliente_id) {
		this.cliente_id = cliente_id;
	}

	public long getBarbeiro_id() {
		return barbeiro_id;
	}

	public void setBarbeiro_id(long barbeiro_id) {
		this.barbeiro_id = barbeiro_id;
	}

	public long getServico_id() {
		return servico_id;
	}

	public void setServico_id(long servico_id) {
		this.servico_id = servico_id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Barbeiro getBarbeiro() {
		return barbeiro;
	}

	public void setBarbeiro(Barbeiro barbeiro) {
		this.barbeiro = barbeiro;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public String getStatusAgendamento() {
		return statusAgendamento;
	}

	public void setStatusAgendamento(String statusAgendamento) {
		this.statusAgendamento = statusAgendamento;
	}
	
}
