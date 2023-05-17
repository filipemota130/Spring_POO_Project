package com.system.manage.models.professor.Professor_Afastado;

import java.util.ArrayList;

import com.system.manage.models.professor.Professor;

public class Professor_Afastado extends Professor {
    
    @Override
    public ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Calculo 1");
        list.add("Calculo 2");
        list.add("Algebra Linear");
        list.add("Sociedade e Ética");
        list.add("Teoria dos Gráfos");
        list.add("Fundamentos da Matemática");
        return list;
    }

    @Override
    public String getCode() {
        return "---Professor Afastado---";
    }
    
    @Override
    public String getAcademicalInfo() {
        return "Afastado";
    }

    @Override
    public String getBool() {
        return "None";
    }
    
}