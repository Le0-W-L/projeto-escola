package com.example.projetoescola.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetoescola.configs.RegraNegocioException;
import com.example.projetoescola.dtos.CategoriaCursoDTO;
import com.example.projetoescola.dtos.CursoDTO;
import com.example.projetoescola.dtos.CursoRequestDTO;
import com.example.projetoescola.dtos.DadosCursoDTO;
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

        @Override
        public List<CursoDTO> obterTodos() {
                List<Curso> cursos = cursoRepository.findAll();
                return cursos.stream().map(c ->
                // new CursoDTO(c.getId(), c.getNome())
                CursoDTO.builder()
                                .id(c.getId())
                                .nome(c.getNome())
                                .build()).toList();
        }

        @Override
        public void remover(Long id) {
                cursoRepository.deleteById(id);
        }

        @Override
        public void editar(Long id, CursoRequestDTO dto) {
                Curso curso = cursoRepository.findById(id)
                                .orElseThrow(() -> new RegraNegocioException("Código curso não encontrado."));

                CategoriaCurso categoriaCurso = categoriaCursoRepository.findById(dto.getCategoriaCursoId())
                                .orElseThrow(() -> new RegraNegocioException("Categoria não encontrado."));

                curso.setNome(dto.getNome());
                curso.setCargaHoraria(dto.getCargaHoraria());
                curso.setCategoriaCurso(categoriaCurso);
                cursoRepository.save(curso);
        }

        @Override
        public DadosCursoDTO obterPorId(Long id) {
                Curso curso = cursoRepository.findById(id)
                                .orElseThrow(() -> new RegraNegocioException("Curso não encontrado"));

                return DadosCursoDTO.builder()
                                .id(curso.getId())
                                .nome(curso.getNome())
                                .cargaHoraria(curso.getCargaHoraria())
                                .categoria(CategoriaCursoDTO.builder()
                                                .id(curso.getCategoriaCurso().getId())
                                                .nome(curso.getCategoriaCurso().getNome())
                                                .build())
                                .build();
        }

}
