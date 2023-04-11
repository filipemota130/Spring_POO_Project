package com.system.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.manage.models.turma.Turma;

public interface turmaRepository extends JpaRepository<Turma, Long> {
    
}
