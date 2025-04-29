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
@Table(name = "PontosFidelidade")
public class PontosFidelidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long pontos;
	private String tipoTransacao;
	private String descricao;
	private LocalDateTime criadoEm;
	private long referencia_id;
	private long cliente_id;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", insertable=false, updatable=false)
	private Cliente cliente;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPontos() {
		return pontos;
	}

	public void setPontos(long pontos) {
		this.pontos = pontos;
	}

	public String getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
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

	public long getReferencia_id() {
		return referencia_id;
	}

	public void setReferencia_id(long referencia_id) {
		this.referencia_id = referencia_id;
	}

	public long getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(long cliente_id) {
		this.cliente_id = cliente_id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
