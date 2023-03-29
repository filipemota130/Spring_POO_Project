package com.system.manage.models.professor;

import java.util.ArrayList;

import com.system.manage.models.modelo.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Professor extends Modelo {

    @Column(name = "formacao")
    private String formacao;
    private String cpf;
    private ArrayList<String> lecionando = new ArrayList<String>();
    private boolean atuando;

    public boolean getBool() {
        return atuando;
    }

    public void setBool(boolean atuando) {
        this.atuando = atuando;
    }

    public ArrayList<String> getList() {
        return lecionando;
    }

    public void setList(String disc) {
        this.lecionando.add(disc);
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