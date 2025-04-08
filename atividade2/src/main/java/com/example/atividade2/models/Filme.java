package com.example.atividade2.models;

import jakarta.persistence.*;

@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private Integer duracao;

    @ManyToOne
    @JoinColumn(name = "diretor_id")
    private Diretor diretor;

    public Filme(Long id, String titulo, Integer duracao) {
        this.id = id;
        this.titulo = titulo;
        this.duracao = duracao;
    }

    public Filme() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    @Override
    public String toString() {
        return "Filme [id=" + id + ", titulo=" + titulo + ", duracao=" + duracao + ", diretor=" + diretor + "]";
    }

}
