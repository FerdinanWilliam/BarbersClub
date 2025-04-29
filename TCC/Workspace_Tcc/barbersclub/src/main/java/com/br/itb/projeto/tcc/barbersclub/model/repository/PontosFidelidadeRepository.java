package com.br.itb.projeto.tcc.barbersclub.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.itb.projeto.tcc.barbersclub.model.entity.PontosFidelidade;

@Repository
public interface PontosFidelidadeRepository extends JpaRepository<PontosFidelidade, Long> {

}
