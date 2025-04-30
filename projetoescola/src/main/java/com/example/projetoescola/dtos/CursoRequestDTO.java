package com.example.projetoescola.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursoRequestDTO {
    private String nome;
    private Integer cargaHoraria;
    private Integer categoriaCursoId;
}