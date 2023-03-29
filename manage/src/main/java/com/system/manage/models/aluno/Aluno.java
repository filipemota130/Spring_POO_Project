package com.system.manage.models.aluno;

import java.util.ArrayList;

import com.system.manage.models.modelo.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Aluno extends Modelo {
    
    // Atributos.
    private String curso;
    private String cpf;
    private ArrayList<String> notas = new ArrayList<String>();
    private boolean statusCurso = true;


    public void setCode(String cpf) {
        this.cpf = cpf;
    }

    public String getCode() {
        return cpf;
    }

    public void setAcademicalInfo(String curso) {
        this.curso = curso;
    }

    public String getAcademicalInfo() {
        return curso;
    }

    public ArrayList<String> getList() {
        return this.notas;
    }

    public void setList(String nota) {
        this.notas.add(nota);
    }

    public void setBool(boolean statusCurso) {
        this.statusCurso = statusCurso;
    }

    public boolean getBool() {
        return statusCurso;
    }

}