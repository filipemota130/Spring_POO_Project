package com.system.manager.database.implement;

import com.system.manager.database.modeloRepository;
import com.system.manager.models.modelo.Modelo;

public abstract class AbstractModelRepository<T extends Modelo> implements modeloRepository<T> {
    
    protected abstract T getModelInstance();


    // implementação dos demais métodos da interface ModelRepository
    // usando o método getModelInstance() para recuperar uma instância da classe
    // modelo
}