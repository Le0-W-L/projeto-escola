package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.Curso;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CursoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Curso salvar(Curso curso) {
        return entityManager.merge(curso);
    }

    public List<Curso> obterTodos() {
        return entityManager.createQuery("from Curso", Curso.class).getResultList();
    }

    @Transactional
    public Curso editar(Long id, Curso cursoAtualizado) {
        // Buscar o curso existente pelo ID
        Curso cursoExistente = entityManager.find(Curso.class, id);

        // Atualizar os dados do curso existente com os valores do novo curso
        cursoExistente.setNome(cursoAtualizado.getNome());
        cursoExistente.setCargaHoraria(cursoAtualizado.getCargaHoraria());

        // Retornar o curso atualizado
        return entityManager.merge(cursoExistente);
    }

    @Transactional
    public void excluir(Long id) {
        //Buscar o curso pelo ID
        Curso curso = entityManager.find(Curso.class, id);

        //Excluir o curso
        entityManager.remove(curso);
    }
}