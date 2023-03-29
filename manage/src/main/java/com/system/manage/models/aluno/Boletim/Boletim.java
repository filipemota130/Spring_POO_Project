package com.system.manage.models.aluno.Boletim;

import java.util.ArrayList;

import com.system.manage.models.aluno.Aluno;

import jakarta.persistence.Entity;

@Entity
public class Boletim extends Aluno {
    int id;
    ArrayList<String> disciplinasAtuais;
    ArrayList<String> disciplinasPagas;

    public ArrayList<String> getDisciplinasPagas() {
        return disciplinasPagas;
    }

    public void setDisciplinasPagas(ArrayList<String> disciplinasPagas) {
        this.disciplinasPagas = disciplinasPagas;
    }

    public int getIdentificador() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getDisciplinasAtuais() {
        return disciplinasAtuais;
    }

    public void setDisciplinasAtuais(String disciplina) {
        this.disciplinasAtuais.add(disciplina);
    }
}
