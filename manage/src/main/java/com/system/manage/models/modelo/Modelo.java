package com.system.manage.models.modelo;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Modelo{

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name="nome")
    private String nome;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract String getAcademicalInfo();

    public abstract void setAcademicalInfo(String E);
    
    public abstract String getCode();

    public abstract void setCode(String E);

    public abstract ArrayList<String> getList();

    public abstract void setList(String E);

}
