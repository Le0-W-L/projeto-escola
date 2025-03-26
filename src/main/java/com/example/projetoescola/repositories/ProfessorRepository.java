package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetoescola.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    public List<Professor> findBySalarioGreaterThan(double salario);

    public List<Professor> findBySalarioLessThanEqual(double salario);
    
    public List<Professor> findByNomeLike(String nome);
}