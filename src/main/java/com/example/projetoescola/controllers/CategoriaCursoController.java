package com.example.projetoescola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/categoria")
public class CategoriaCursoController {
    @Autowired
    private CategoriaCursoRepository categoriaCursoRepository;
    
    //Rota pra listar todas as categorias de curso
    @GetMapping()
    public List<CategoriaCurso> listaCategoriasCursos() {
        return categoriaCursoRepository.listar();
    }
    
    //Rota para inserir categorias de curso
    @PostMapping("/inserir")
    public CategoriaCurso inserirCategoriaCurso(@RequestBody CategoriaCurso categoriaCurso) {
        return categoriaCursoRepository.inserir(categoriaCurso);
    }
    
    //Rota para excluir categorias com base no ID
    @DeleteMapping("/{id}")
    public void excluirPorId(@PathVariable Integer id){
        categoriaCursoRepository.excluirPorId(id);
    }

    //Rota para atualizar categorias com base no ID
    @PutMapping("/{id}")
    public CategoriaCurso editar(@PathVariable Integer id, @RequestBody CategoriaCurso categoriaCurso) {
        return categoriaCursoRepository.editar(id, categoriaCurso);
    }
}