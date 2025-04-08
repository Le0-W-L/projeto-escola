package com.example.atividade2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.atividade2.models.Diretor;

import java.util.List;

public interface DiretorRepository extends JpaRepository<Diretor, Long> {

    List<Diretor> findByNomeStartingWith(String nome);

    @Query("SELECT d FROM Diretor d LEFT JOIN FETCH d.filmes WHERE d.id = :id")
    Diretor findByIdComFilmes(Long id);
}
