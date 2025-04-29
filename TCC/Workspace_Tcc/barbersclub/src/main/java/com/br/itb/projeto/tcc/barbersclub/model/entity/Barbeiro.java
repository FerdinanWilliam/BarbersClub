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
@Table(name = "Barbeiro")
public class Barbeiro {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String biografia;
	private String especialidades;
	private long tempoExperiencia;
	private double mediaAvaliacao;
	private boolean disponibilidade;
	private LocalDateTime horarioInicial;
	private LocalDateTime horarioFinal;
	private LocalDateTime criadoEm;
	private LocalDateTime atualizadoEm;
	private long barbearia_id;
	
	@ManyToOne
	@JoinColumn(name = "barbearia_id", insertable=false, updatable=false)
	private Barbearia barbearia;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	public String getEspecialidades() {
		return especialidades;
	}
	public void setEspecialidades(String especialidades) {
		this.especialidades = especialidades;
	}
	public long getTempoExperiencia() {
		return tempoExperiencia;
	}
	public void setTempoExperiencia(long tempoExperiencia) {
		this.tempoExperiencia = tempoExperiencia;
	}
	public double getMediaAvaliacao() {
		return mediaAvaliacao;
	}
	public void setMediaAvaliacao(double mediaAvaliacao) {
		this.mediaAvaliacao = mediaAvaliacao;
	}
	public boolean isDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	public LocalDateTime getHorarioInicial() {
		return horarioInicial;
	}
	public void setHorarioInicial(LocalDateTime horarioInicial) {
		this.horarioInicial = horarioInicial;
	}
	public LocalDateTime getHorarioFinal() {
		return horarioFinal;
	}
	public void setHorarioFinal(LocalDateTime horarioFinal) {
		this.horarioFinal = horarioFinal;
	}
	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}
	public void setCriadoEm(LocalDateTime criadoEm) {
		this.criadoEm = criadoEm;
	}
	public LocalDateTime getAtualizadoEm() {
		return atualizadoEm;
	}
	public void setAtualizadoEm(LocalDateTime atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}
	public long getBarbearia_id() {
		return barbearia_id;
	}
	public void setBarbearia_id(long barbearia_id) {
		this.barbearia_id = barbearia_id;
	}
	public Barbearia getBarbearia() {
		return barbearia;
	}
	public void setBarbearia(Barbearia barbearia) {
		this.barbearia = barbearia;
	}
	
}
