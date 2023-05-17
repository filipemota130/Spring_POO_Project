package com.system.manage.command.professorCommands;

import com.system.manage.command.Command;
import com.system.manage.repositories.professorRepository;

public class DeletarProfessorCommand implements Command<professorRepository> {
    Long id;

    public DeletarProfessorCommand(Long id) {
        this.id = id;
    }

    @Override
    public void execute(professorRepository repo) {
        repo.deleteById(id);
    }
}
