package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetoescola.models.Curso;

// Interface -> nao instancia objeto (modelo a ser seguido)
// Classe -> instancia objeto
public interface CursoRepository extends JpaRepository<Curso, Long> {
    public List<Curso> findByNome(String nome);

    public List<Curso> findByNomeLike(String nome);
}