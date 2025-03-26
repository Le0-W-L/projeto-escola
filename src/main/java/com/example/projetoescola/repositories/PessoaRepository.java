package com.example.projetoescola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetoescola.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}