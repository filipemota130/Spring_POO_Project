package com.system.manage.models.aluno.Boletim;

import java.util.ArrayList;

import com.system.manage.models.aluno.Aluno;

import jakarta.persistence.Entity;

@Entity
public class Boletim extends Aluno {

    int id;

    public int getIdentificador() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<String>();
        try{
            for (int i = 0; i < this.notas.size(); i++) {
                String[] separador = this.notas.get(i).split(":");
                list.add(separador[0] + " ------ " +" Nota:" + separador[1]);
            }
            return list; 
        }
        catch (Exception e) {
            list.add("Erro, formato da nota inválido!!");
            return list;
        }
    }
}
