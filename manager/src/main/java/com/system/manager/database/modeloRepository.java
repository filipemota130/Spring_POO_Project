package com.system.manager.database;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.manager.models.modelo.Modelo;


public interface modeloRepository<T extends Modelo> extends JpaRepository<Modelo, Long> {
    
    T save(T model);
    
    Optional<Modelo> findById(Long id);

    List<Modelo> findAll();

    T update(T model);

    void delete(Long id);
    
}
