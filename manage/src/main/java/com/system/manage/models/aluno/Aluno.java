package com.system.manage.models.aluno;

import java.util.ArrayList;

import com.system.manage.models.modelo.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Aluno extends Modelo{
    
    // Atributos.
    @Column(name = "Curso")
    public String curso;

    @Column(name = "CPF")
    public String cpf;

    @Column(name = "Notas")
    public ArrayList<String> notas = new ArrayList<String>();

    @Column(name = "Status")
    private boolean statusCurso = true;

    @Column(name = "Disciplinas_Pagas")
    public ArrayList<String> Disciplinas_Pagas = new ArrayList<String>();

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

    public boolean getBool() {
        return statusCurso;
    }
    
    public ArrayList<String> getDisciplinasPagas() {
        return this.Disciplinas_Pagas;
    }
    
    public void setDisciplinasPagas(String disciplinasPaga) {
        this.Disciplinas_Pagas.add(disciplinasPaga);
    }
    public Aluno CreateInstance(Long id,String nome, String curso, String cpf, String notas,String pagas,
            boolean status) {
        Aluno aluno = new Aluno();
        aluno.setAcademicalInfo(curso);
        aluno.setBool(status);
        aluno.setId(id);
        aluno.setNome(nome);
        aluno.setCode(cpf);
        String[] new_notas = notas.split(";");
        for (int i = 0; i < new_notas.length; i++) {
            aluno.setList(new_notas[i]);
        }
        String[] new_notas_pagas = pagas.split(";");
        for (int i = 0; i < new_notas_pagas.length; i++) {
            aluno.setDisciplinasPagas(new_notas_pagas[i]);
        }
        return aluno;
    }
}