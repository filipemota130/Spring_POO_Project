package com.system.manage.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.CannotCreateTransactionException;

import com.system.manage.models.aluno.Aluno;
import com.system.manage.repositories.alunoRepository;

public class RegistrarAlunoCommand implements Command<alunoRepository> {

    private Aluno aluno;

    public RegistrarAlunoCommand(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public String executar(alunoRepository repo) {
            repo.save(aluno);
            return "Aluno Criado/Alterado!";
    }



}