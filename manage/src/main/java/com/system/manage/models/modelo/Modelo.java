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

    public ArrayList<String> Ver_info() {
        ArrayList<String> ver_info = new ArrayList<String>();
        ver_info.add(Long.toString(getId()));
        ver_info.add(getNome());
        ver_info.add(getCode());
        ver_info.add(getAcademicalInfo());
        return ver_info;
    }

    public abstract String getAcademicalInfo();

    public abstract void setAcademicalInfo(String E);
    
    public abstract String getCode();

    public abstract void setCode(String E);

    public abstract ArrayList<String> getList();

    public abstract void setList(String E);

    public abstract boolean getBool();

    public abstract void setBool(boolean E);

}
