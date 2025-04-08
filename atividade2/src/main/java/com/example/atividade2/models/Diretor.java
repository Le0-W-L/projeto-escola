package com.example.atividade2.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Diretor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "diretor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Filme> filmes;

    public Diretor(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Diretor() {
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

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    @Override
    public String toString() {
        return "Diretor [id=" + id + ", nome=" + nome + "]";
    }

}