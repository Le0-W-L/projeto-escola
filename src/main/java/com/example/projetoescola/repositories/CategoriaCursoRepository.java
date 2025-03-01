package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.CategoriaCurso;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaCursoRepository {
    @Autowired
    private EntityManager entityManager;

    //Exibir todas as categorias de curso
    public List<CategoriaCurso> listar(){
        return entityManager.createQuery("from CategoriaCurso", CategoriaCurso.class).getResultList();
    }

    //Adicionar categorias de curso
    @Transactional
    public CategoriaCurso inserir(CategoriaCurso categoriaCurso){
        return entityManager.merge(categoriaCurso);
    }

    //Excluir com base no ID
    @Transactional
    public void excluirPorId(Integer id){
        CategoriaCurso categoriaCurso = entityManager.find(CategoriaCurso.class, id);

        entityManager.remove(categoriaCurso);
    }
}