package com.system.manager.models.turma;

import java.util.ArrayList;

import com.system.manager.models.modelo.Modelo;

public class Turma extends Modelo {
    private ArrayList<String> dias;
    private ArrayList<String> horarios;
    private String professor;
    private ArrayList<String> alunos;

    public Turma(int id, String nome, ArrayList<String> dias, ArrayList<String> horarios, String professor,
            ArrayList<String> alunos) {
        super(id,nome);
        this.dias = dias;
        this.horarios = horarios;
        this.professor = professor;
        this.alunos = alunos;
    }

    public void Ver_info() {
        System.out.println("ID: " + getId() +
                "\nDisciplina: " + getNome() +
                "\ndias: " + this.dias +
                "\nhorários: " + this.horarios +
                "\nprofessor: " + this.professor +
                "\nalunos: " + this.alunos);
    }

    public void setDias(ArrayList<String> dias) {
        this.dias = dias;
    }

    public ArrayList<String> getDias() {
        return this.dias;
    }

    public void setHorarios(ArrayList<String> horarios) {
        this.horarios = horarios;
    }

    public ArrayList<String> getHorarios() {
        return this.horarios;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getProfessor() {
        return this.professor;
    }

    public void setAlunos(ArrayList<String> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<String> getAlunos() {
        return this.alunos;
    }

    @Override
    public Turma clone() throws CloneNotSupportedException {
        return (Turma) super.clone();
    }
}