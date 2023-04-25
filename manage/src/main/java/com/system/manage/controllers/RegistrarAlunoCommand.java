package com.system.manage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.CannotCreateTransactionException;

import com.system.manage.models.aluno.Aluno;
import com.system.manage.repositories.alunoRepository;

public class RegistrarAlunoCommand implements Command<Aluno> {

    @Autowired
    alunoRepository repos;

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

    public String executar(Aluno a) {
        try {
            repos.save(a);
            return "Aluno Criado/Alterado!";
        } catch (CannotCreateTransactionException e) {
            return e.toString();
        } catch (NullPointerException e) {
            return a.getNome();
        }
    }

}
