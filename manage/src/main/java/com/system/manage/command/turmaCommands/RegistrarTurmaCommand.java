package com.system.manage.command.turmaCommands;

import org.springframework.beans.factory.annotation.Autowired;

import com.system.manage.command.Command;
import com.system.manage.models.turma.Turma;
import com.system.manage.repositories.turmaRepository;

public class RegistrarTurmaCommand implements Command<turmaRepository>{
    private Turma turma = new Turma();

    @Autowired
    turmaRepository repo;

    public RegistrarTurmaCommand(Long id, String nome, String professor, String horarios, String alunos, boolean monitor) {
        this.turma.setId(id);
        this.turma.setNome(nome);
        this.turma.setAcademicalInfo(professor);
        this.turma.setBool(monitor);
        this.turma.setCode(horarios);
        String[] new_alunos = alunos.split(";");
        for (int i = 0; i < new_alunos.length; i++) {
            this.turma.setList(new_alunos[i]);
        }
    }

    @Override
    public void execute(turmaRepository repo) {
        repo.save(turma);
    }
}
