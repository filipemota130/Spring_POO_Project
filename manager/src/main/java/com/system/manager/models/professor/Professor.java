package com.system.manager.models.professor;

import com.system.manager.models.modelo.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Professor extends Modelo {

    @Column(name = "formacao")
    private String formacao;

    public Professor(Long id, String nome, String formacao) {
        super(id, nome);
        this.formacao = formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getFormacao() {
        return this.formacao;
    }

    public void Ver_info() {
        System.out.printf("\nID: %d\n", getId());
        System.out.printf("Nome: %s\n", getNome());
        System.out.printf("Formação: %s\n\n", getFormacao());
    }

}