package com.system.manage.models.aluno.HistoricoAnalitico;

import java.util.ArrayList;

import com.system.manage.models.aluno.Aluno;

public class historicoAnalitico extends Aluno{
    public ArrayList<String> disciplinasPagas;
    private Double carga;
    double coeficiente = 0.0;

    public Double getCarga() {
        for (int i = 0; i < this.notas.size(); i++) {
            this.carga += 72;
        }
        return carga;
    }

    public Double getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(ArrayList<String> notas) {
        for (int i = 0; i < notas.size(); i++) {
            String[] new_notas = notas.get(i).split(":");
            this.coeficiente = this.coeficiente + Math.round(Double.parseDouble(new_notas[1]) * 72);
        }
        this.coeficiente = (this.coeficiente / (72*notas.size()));
    }

    @Override
    public ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < this.Disciplinas_Pagas.size(); i++) {
            String[] separador = this.Disciplinas_Pagas.get(i).split(":");
            String status = "Aprovado";
            if (Double.parseDouble(separador[1]) < 7.0) {
                status = "Reprovado";
            }
            list.add(separador[0] + " | Carga Horaria: "+ 72 +" | Nota Final: " + separador[1] + " Status: "+ status);
        }
        return list;
    }

}
