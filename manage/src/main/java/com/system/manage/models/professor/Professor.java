package com.system.manage.models.professor;

import java.util.ArrayList;

import com.system.manage.models.modelo.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Professor extends Modelo {

    @Column(name="formacao")
    private String formacao;

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getFormacao() {
        return this.formacao;
    }

    public ArrayList<String> Ver_info() {
        ArrayList<String> ver_info = new ArrayList<String>();
        ver_info.add(Long.toString(getId()));
        ver_info.add(getNome());
        ver_info.add(getFormacao());
        return ver_info;
    }

}