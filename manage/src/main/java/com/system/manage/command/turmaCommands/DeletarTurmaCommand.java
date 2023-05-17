package com.system.manage.command.turmaCommands;

import com.system.manage.command.Command;
import com.system.manage.repositories.turmaRepository;

public class DeletarTurmaCommand implements Command<turmaRepository>{
    Long id;

    public DeletarTurmaCommand(Long id) {
        this.id = id;
    }

    @Override
    public void execute(turmaRepository repo) {
        repo.deleteById(id);
    }
}
