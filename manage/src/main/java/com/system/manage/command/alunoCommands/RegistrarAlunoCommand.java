package com.system.manage.command.alunoCommands;

import org.springframework.beans.factory.annotation.Autowired;

import com.system.manage.command.Command;
import com.system.manage.models.aluno.Aluno;
import com.system.manage.repositories.alunoRepository;

public class RegistrarAlunoCommand implements Command<alunoRepository>{

    private Aluno aluno = new Aluno();

    @Autowired
    alunoRepository repo;

    public RegistrarAlunoCommand(Long id, String nome, String curso, String cpf, String notas, String pagas, boolean status) {
        this.aluno.setId(id);
        this.aluno.setNome(nome);
        this.aluno.setAcademicalInfo(curso);
        this.aluno.setBool(status);
        this.aluno.setCode(cpf);
        String[] new_notas = notas.split(";");
        for (int i = 0; i < new_notas.length; i++) {
            this.aluno.setList(new_notas[i]);
        }
        String[] new_notas_pagas = pagas.split(";");
        for (int i = 0; i < new_notas_pagas.length; i++) {
            this.aluno.setDisciplinasPagas(new_notas_pagas[i]);
        }
    }

    @Override
    public void execute(alunoRepository repo) {
        repo.save(aluno);
    }



}