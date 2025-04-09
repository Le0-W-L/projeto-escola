package com.example.projetoescola.services;

import java.util.List;

import com.example.projetoescola.dtos.CursoDTO;
import com.example.projetoescola.dtos.CursoRequestDTO;

public interface CursoService {
    CursoDTO salvar(CursoRequestDTO curso);

    List<CursoDTO> obterTodos();
}
