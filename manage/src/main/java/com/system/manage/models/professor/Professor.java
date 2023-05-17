package com.system.manage.models.professor;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Professor{

    @Id
    @Column(name = "id")
    public Long id;

    @Column(name = "nome")
    public String nome;

    @Column(name = "formacao")
    private String formacao;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "Lista")
    public ArrayList<String> lista = new ArrayList<String>();

    @Column(name = "Status")
    private String atuacao;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getBool() {
        return atuacao;
    }

    public void setBool(String atuacao) {
        this.atuacao = atuacao;
    }

    public ArrayList<String> getList() {
        return lista;
    }

    public void setList(String disc) {
        this.lista.add(disc);
    }

    public String getCode() {
        return cpf;
    }

    public void setCode(String cpf) {
        this.cpf = cpf;
    }

    public void setAcademicalInfo(String formacao) {
        this.formacao = formacao;
    }

    public String getAcademicalInfo() {
        return this.formacao;
    }

}