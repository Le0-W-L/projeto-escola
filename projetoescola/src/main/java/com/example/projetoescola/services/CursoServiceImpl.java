package com.example.projetoescola.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetoescola.configs.RegraNegocioException;
import com.example.projetoescola.dtos.CursoDTO;
import com.example.projetoescola.dtos.CursoRequestDTO;
import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private CategoriaCursoRepository categoriaCursoRepository;

    @Override
    public CursoDTO salvar(CursoRequestDTO curso) {
        CategoriaCurso categoriaCurso = categoriaCursoRepository.findById(
                curso.getCategoriaCursoId())
                .orElseThrow(() -> new RegraNegocioException("Categoria não encontrada"));

        Curso c = new Curso(null,
                curso.getNome(),
                curso.getCargaHoraria());
        c.setCategoriaCurso(categoriaCurso);
        c = cursoRepository.save(c);
        return new CursoDTO(c.getId(), c.getNome());
    }

}
