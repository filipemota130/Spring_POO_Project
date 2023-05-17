package com.system.manage.models.professor.Professor_Orientador;

import java.util.ArrayList;

import com.system.manage.models.professor.Professor;

public class Professor_Orientador extends Professor {

    @Override
    public ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("John Peter");
        list.add("Bruce Wayne");
        list.add("Silvester Stalone");
        list.add("Arnold Schwarzenegger");
        list.add("Belle Belinha");
        list.add("Maycon Kuster");
        return list;
    }

    @Override
    public String getCode() {
        return "---Orientador de Projetos---";
    }

    @Override
    public String getBool() {
        return "None";
    }

    @Override
    public String getAcademicalInfo() {
        return "Orientador";
    }
}