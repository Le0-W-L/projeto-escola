package com.example.projetoescola.services;

import java.util.List;

import com.example.projetoescola.dtos.CursoDTO;
import com.example.projetoescola.dtos.CursoRequestDTO;
import com.example.projetoescola.dtos.DadosCursoDTO;

public interface CursoService {
    CursoDTO salvar(CursoRequestDTO curso);

    List<CursoDTO> obterTodos();

    DadosCursoDTO obterPorId(Long id);

    void remover(Long id);

    void editar(Long id, CursoRequestDTO dto);
}