package com.system.manage.command.professorCommands;

import org.springframework.beans.factory.annotation.Autowired;

import com.system.manage.command.Command;
import com.system.manage.models.professor.Professor;
import com.system.manage.repositories.professorRepository;

public class RegistrarProfessorCommand implements Command<professorRepository>{

    private Professor professor = new Professor();

    @Autowired
    professorRepository repo;

    public RegistrarProfessorCommand(Long id, String nome, String formacao, String disciplinas, boolean status) {
        this.professor.setId(id);
        this.professor.setNome(nome);
        this.professor.setAcademicalInfo(formacao);
        this.professor.setBool(status);
        //this.professor.setCode(cpf);
        String[] new_disciplinas = disciplinas.split(";");
        for (int i = 0; i < new_disciplinas.length; i++) {
            this.professor.setList(new_disciplinas[i]);
        }
    }

    @Override
    public void execute(professorRepository repo) {
        repo.save(professor);
    }
}