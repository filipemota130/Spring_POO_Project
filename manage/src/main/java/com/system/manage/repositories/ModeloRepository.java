package com.system.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.manage.models.modelo.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo,Long> {
    
}
