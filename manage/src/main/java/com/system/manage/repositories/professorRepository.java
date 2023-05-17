package com.system.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.manage.models.professor.Professor;


public interface professorRepository extends JpaRepository<Professor,Long> {
    
}