package com.system.manage.models.aluno.HistoricoAnalitico;

import java.util.ArrayList;

import com.system.manage.models.aluno.Aluno;

public class historicoAnalitico extends Aluno{
    ArrayList<String> disciplinasAtuais;
    ArrayList<String> disciplinasPagas;

    public ArrayList<String> getDisciplinasAtuais() {
        return disciplinasAtuais;
    }

    public void setDisciplinasAtuais(String disciplina) {
        this.disciplinasAtuais.add(disciplina);
    }

    public ArrayList<String> getDisciplinasPagas() {
        return disciplinasPagas;
    }

    public void setDisciplinasPagas(ArrayList<String> disciplinasPagas) {
        this.disciplinasPagas = disciplinasPagas;
    }
}
