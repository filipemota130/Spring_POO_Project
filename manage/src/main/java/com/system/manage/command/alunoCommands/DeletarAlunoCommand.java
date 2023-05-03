package com.system.manage.command.alunoCommands;

import com.system.manage.command.Command;
import com.system.manage.repositories.alunoRepository;

public class DeletarAlunoCommand implements Command<alunoRepository> {

    Long id;

    public DeletarAlunoCommand(Long id) {
        this.id = id;
    }

    @Override
    public void execute(alunoRepository repo) {
        repo.deleteById(id);
    }
    
}
