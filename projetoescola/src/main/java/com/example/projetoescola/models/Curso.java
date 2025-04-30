package com.example.projetoescola.models;

import java.util.List;

import com.example.projetoescola.configs.validations.NomeCursoValidation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome do curso não pode ser vazio")
    @Column(nullable = false, length = 200)
    @NomeCursoValidation(message = "O nome do curso deve seguir o padrão: 5 letras minúsculas seguidas de 2 números.")
    private String nome;

    @Min(value = 1500, message = "A carga horária deve ser maior ou igual a 1500.")
    @Column(nullable = false)
    private Integer cargaHoraria;

    @ManyToOne
    @JoinColumn(name = "categoriaCurso_ID")
    private CategoriaCurso categoriaCurso;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Curso_Pessoa", joinColumns = {
            @JoinColumn(name = "Curso_ID") }, inverseJoinColumns = {
                    @JoinColumn(name = "Pessoa_ID") })
    private List<Pessoa> pessoas;

    public void addPessoa(Pessoa p) {
        pessoas.add(p);
    }

    public CategoriaCurso getCategoriaCurso() {
        return categoriaCurso;
    }

    public void setCategoriaCurso(CategoriaCurso categoriaCurso) {
        this.categoriaCurso = categoriaCurso;
    }

    public Curso(Long id, String nome, Integer cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public Curso() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso [id=" + id + ", nome=" + nome + ", cargaHoraria=" + cargaHoraria + "]";
    }
}