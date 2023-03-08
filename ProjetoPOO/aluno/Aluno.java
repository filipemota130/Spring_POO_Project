package aluno;

import java.util.ArrayList;

import modelo.Modelo;

public class Aluno extends Modelo{
    // Atributos.
    private int matricula;
    private String email;
    private int cpf;
    private ArrayList<String> notas = new ArrayList<String>();
    private ArrayList<String> historicoAnalitico = new ArrayList<String>();
    private ArrayList<String> disciplinasAtuais = new ArrayList<String>();
    private boolean statusCurso = true;

    // Cadastrar informações dos alunosCadastrados.
    public Aluno(int id, String nome, int matricula, String email, int cpf) {
        super(id, nome);
        this.matricula = matricula;
        this.email = email;
        this.cpf = cpf;
    }

    // Exibir todas as informações.
    public void Ver_info() {
        System.out.print("Nome: " + getNome() +
                "\nMatrícula: " + this.matricula +
                "\nCPF: " + this.cpf +
                "\nE-mail: " + this.email + "\n");
        if (statusCurso == true) {
            System.out.println("Status: Ativo\n");
        } else {
            System.out.println("Status: Trancado\n");
        }
    }

    // função boletim
    public void printBoletim() {
        for (int i = 0; i < notas.size(); i++) {
            System.out.println(notas.get(i));
        }
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getCpf() {
        return cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<String> getNotas() {
        return this.notas;
    }

    public void setNotas(String nota) {
        this.notas.add(nota);
    }

    public void setStatusCurso(boolean statusCurso) {
        this.statusCurso = statusCurso;
    }

    public boolean getStatusCurso() {
        return statusCurso;
    }

    public ArrayList<String> getHistoricoAnalitico() {
        return historicoAnalitico;
    }

    public void setHistoricoAnalitico(String dadoHistorico) {
        this.historicoAnalitico.add(dadoHistorico);
    }

    public void printHistorico() {
        for (int i = 0; i < historicoAnalitico.size(); i++) {
            System.out.println(historicoAnalitico.get(i));
        }
    }

    public ArrayList<String> getDisciplinasAtuais() {
        return disciplinasAtuais;
    }

    public void setDisciplinasAtuais(String disciplina) {
        this.disciplinasAtuais.add(disciplina);
    }

    public void printDisciplina() {
        if (disciplinasAtuais.isEmpty()) {
            System.out.println("O aluno não está matriculado em nenhuma disciplina.");
        } else {
            for (int i = 0; i < disciplinasAtuais.size(); i++) {
                System.out.println(disciplinasAtuais.get(i));
            }
        }
    }

}