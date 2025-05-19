package com.br.itb.projeto.tcc.barbersclub.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.itb.projeto.tcc.barbersclub.model.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
