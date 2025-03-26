package com.example.projetoescola.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "professores")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double salario;
    
    public Professor() {
    }

    public Professor(Long id, String nome, double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
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
    public double getPreco() {
        return salario;
    }
    public void setPreco(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Professor [id=" + id + ", nome=" + nome + ", salario=" + salario + "]";
    }
}