package com.system.manage.models.aluno;

import java.util.ArrayList;

import com.system.manage.models.modelo.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Aluno extends Modelo {
    
    // Atributos.
    @Column(name = "Curso")
    public String curso;

    @Column(name = "CPF")
    public String cpf;

    @Column(name = "Notas")
    public ArrayList<String> notas = new ArrayList<String>();

    @Column(name = "Status")
    private boolean statusCurso = true;


    public void setCode(String cpf) {
        this.cpf = cpf;
    }

    public String getCode() {
        return cpf;
    }

    public void setAcademicalInfo(String curso){
        this.curso = curso;
    }

    public String getAcademicalInfo(){
        return curso;
    }

    public ArrayList<String> getList(){
        return this.notas;
    }

    public void setList(String nota){
        this.notas.add(nota);
    }

    public void setBool(boolean statusCurso){
        this.statusCurso = statusCurso;
    }

    public boolean getBool(){
        return statusCurso;
    }

}