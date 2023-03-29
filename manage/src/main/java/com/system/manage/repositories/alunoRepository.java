package com.system.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.manage.models.aluno.Aluno;

public interface alunoRepository extends JpaRepository<Aluno,Integer> {
    
}
