package com.system.manage.models.turma;
import java.util.ArrayList;

import com.system.manage.models.modelo.Modelo;

import jakarta.persistence.Column;

public class Turma extends Modelo {
    
    @Column(name = "diaseHorarios")
    private String diaseHorarios;

    @Column(name = "professor")
    private String professor;

    @Column(name = "alunos")
    private ArrayList<String> alunos = new ArrayList<String>();
    
    @Column(name = "monitor")
    private boolean monitor;

    public boolean getBool() {
        return monitor;
    }

    public void setBool(boolean monitor) {
        this.monitor = monitor;
    }

    public String getCode() {
        return diaseHorarios;
    }

    public void setCode(String diaseHorarios) {
        this.diaseHorarios = diaseHorarios;
    }

    public void setAcademicalInfo(String professor) {
        this.professor = professor;
    }

    public String getAcademicalInfo() {
        return this.professor;
    }

    public void setList(String aluno) {
        this.alunos.add(aluno);
    }

    public ArrayList<String> getList() {
        return this.alunos;
    }

}