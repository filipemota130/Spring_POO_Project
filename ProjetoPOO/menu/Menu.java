package menu;

import java.util.ArrayList;
import java.util.Scanner;

import professor.Professor;
import turma.Turma;
import aluno.Aluno;
import modelo.Modelo;

public class Menu {
    public void undoRedo(ArrayList<String> OP1, ArrayList<String> OP2, ArrayList<Modelo> entidades,
            ArrayList<Modelo> entidades_removidas, ArrayList<Modelo> entidades_pre_edicao,
            ArrayList<Modelo> entidades_editadas) {

        String operation = OP1.get(OP1.size() - 1);
        String[] comando = operation.split(":");
        if (comando[0].equals("add")) {
            for (int i = entidades.size() - 1; i >= 0; i--) {
                if (comando[1].equals("prof")) {
                    if (entidades.get(i) instanceof Professor) {
                        entidades_removidas.add(entidades.get(i));
                        entidades.remove(i);
                        OP2.add("rm:prof");
                        break;
                    }
                } else if (comando[1].equals("aluno")) {
                    if (entidades.get(i) instanceof Aluno) {
                        entidades_removidas.add(entidades.get(i));
                        entidades.remove(i);
                        OP2.add("rm:aluno");
                        break;
                    }
                } else if (comando[1].equals("turma")) {
                    if (entidades.get(i) instanceof Turma) {
                        entidades_removidas.add(entidades.get(i));
                        entidades.remove(i);
                        OP2.add("rm:turma");
                        break;
                    }
                }
            }
        } else if (comando[0].equals("rm")) {
            for (int i = entidades_removidas.size() - 1; i >= 0; i--) {
                if (comando[1].equals("prof")) {
                    if (entidades_removidas.get(i) instanceof Professor) {
                        entidades.add(entidades_removidas.get(i));
                        entidades_removidas.remove(i);
                        OP2.add("add:prof");
                        break;
                    }
                } else if (comando[1].equals("aluno")) {
                    if (entidades_removidas.get(i) instanceof Aluno) {
                        entidades.add(entidades_removidas.get(i));
                        entidades_removidas.remove(i);
                        OP2.add("add:aluno");
                        break;
                    }
                } else if (comando[1].equals("turma")) {
                    if (entidades_removidas.get(i) instanceof Turma) {
                        entidades.add(entidades_removidas.get(i));
                        entidades_removidas.remove(i);
                        OP2.add("add:turma");
                        break;
                    }
                }
            }
        } else if (comando[0].equals("edit")) {
            if (comando[1].equals("prof")) {
                if (comando[2].equals("undo")) {
                    for (int i = entidades_pre_edicao.size() - 1; i >= 0; i--) {
                        if (entidades_pre_edicao.get(i) instanceof Professor) {
                            Professor buscador = (Professor) entidades_pre_edicao.get(i);
                            for (int j = 0; j < entidades.size(); j++) {
                                if (entidades.get(j).getId() == buscador.getId()
                                        && (entidades.get(j) instanceof Professor)) {
                                    entidades_editadas.add(entidades.get(i));
                                    entidades.remove(i);
                                    entidades.add(buscador);
                                    OP2.add("edit:prof:redo");
                                    break;
                                }
                            }
                            entidades_pre_edicao.remove(buscador);
                            break;
                        }
                    }
                } else {
                    for (int i = entidades_editadas.size() - 1; i >= 0; i--) {
                        if (entidades_editadas.get(i) instanceof Professor) {
                            Professor buscador = (Professor) entidades_editadas.get(i);
                            for (int j = 0; j < entidades.size(); j++) {
                                if (entidades.get(j).getId() == buscador.getId()
                                        && (entidades.get(j) instanceof Professor)) {
                                    entidades_pre_edicao.add(entidades.get(i));
                                    entidades.remove(i);
                                    entidades.add(buscador);
                                    OP2.add("edit:prof:undo");
                                    break;
                                }
                            }
                            entidades_editadas.remove(buscador);
                            break;
                        }
                    }
                }
            } else if (comando[1].equals("aluno")) {
                if (comando[2].equals("undo")) {
                    for (int i = entidades_pre_edicao.size() - 1; i >= 0; i--) {
                        if (entidades_pre_edicao.get(i) instanceof Aluno) {
                            Aluno buscador = (Aluno) entidades_pre_edicao.get(i);
                            for (int j = 0; j < entidades.size(); j++) {
                                if (entidades.get(j).getId() == buscador.getId()
                                        && (entidades.get(j) instanceof Aluno)) {
                                    entidades_editadas.add(entidades.get(i));
                                    entidades.remove(i);
                                    entidades.add(buscador);
                                    OP2.add("edit:aluno:redo");
                                    break;
                                }
                            }
                            entidades_pre_edicao.remove(buscador);
                            break;
                        }
                    }
                } else {
                    for (int i = entidades_editadas.size() - 1; i >= 0; i--) {
                        if (entidades_editadas.get(i) instanceof Aluno) {
                            Aluno buscador = (Aluno) entidades_editadas.get(i);
                            for (int j = 0; j < entidades.size(); j++) {
                                if (entidades.get(j).getId() == buscador.getId()
                                        && (entidades.get(j) instanceof Aluno)) {
                                    entidades_pre_edicao.add(entidades.get(i));
                                    entidades.remove(i);
                                    entidades.add(buscador);
                                    OP2.add("edit:aluno:undo");
                                    break;
                                }
                            }
                            entidades_editadas.remove(buscador);
                            break;
                        }
                    }
                }
            } else {
                if (comando[2].equals("undo")) {
                    for (int i = entidades_pre_edicao.size() - 1; i >= 0; i--) {
                        if (entidades_pre_edicao.get(i) instanceof Aluno) {
                            Aluno buscador = (Aluno) entidades_pre_edicao.get(i);
                            for (int j = 0; j < entidades.size(); j++) {
                                if (entidades.get(j).getId() == buscador.getId()
                                        && (entidades.get(j) instanceof Aluno)) {
                                    entidades_editadas.add(entidades.get(i));
                                    entidades.remove(i);
                                    entidades.add(buscador);
                                    OP2.add("edit:aluno:redo");
                                    break;
                                }
                            }
                            entidades_pre_edicao.remove(buscador);
                            break;
                        }
                    }
                } else {
                    for (int i = entidades_editadas.size() - 1; i >= 0; i--) {
                        if (entidades_editadas.get(i) instanceof Turma) {
                            Turma buscador = (Turma) entidades_editadas.get(i);
                            for (int j = 0; j < entidades.size(); j++) {
                                if (entidades.get(j).getId() == buscador.getId()
                                        && (entidades.get(j) instanceof Turma)) {
                                    entidades_pre_edicao.add(entidades.get(i));
                                    entidades.remove(i);
                                    entidades.add(buscador);
                                    OP2.add("edit:turma:undo");
                                    break;
                                }
                            }
                            entidades_editadas.remove(buscador);
                            break;
                        }
                    }
                }
            }
        }
        OP1.remove(OP1.size() - 1);
    }
    
    public static void main(String args[]) throws CloneNotSupportedException {
        ArrayList<String> undoList = new ArrayList<String>();
        ArrayList<String> redoList = new ArrayList<String>();

        ArrayList<Modelo> entidades = new ArrayList<Modelo>();
        ArrayList<Modelo> entidades_pre_edicao = new ArrayList<Modelo>();
        ArrayList<Modelo> entidades_editadas = new ArrayList<Modelo>();
        ArrayList<Modelo> entidades_removidas = new ArrayList<Modelo>();
        /* 
        Aluno alunoT = new Aluno(10, "nome", 10, "email", 79589485);
        entidades.add(alunoT);
        Professor prof1 = new Professor(123456789, "Badu", 123456789, "Doutor");
        entidades.add(prof1);
        */
        Scanner leitor = new Scanner(System.in);

        while (true) {
            System.out.println("[1] - Turmas");
            System.out.println("[2] - Professores");
            System.out.println("[3] - Alunos");
            System.out.println("[4] - Desfazer ultima a????o");
            System.out.println("[5] - Resfazer ultima a????o");
            System.out.println("[6] - Sair");
            System.out.print("Selecione um dos comandos: ");
            int x = 0;
            x = leitor.nextInt();

            // PROFESSOR
            if (x == 2) {
                int id;
                Professor profExample = new Professor(0, null, 1, null);
                System.out.println("[1] - Adicionar novo professor");
                System.out.println("[2] - editar informa????es");
                System.out.println("[3] - exibir informa????es");
                System.out.println("[4] - Remover professor");
                System.out.print("Selecione um dos comandos: ");

                int option = leitor.nextInt();

                // adicionar professor
                if (option == 1) {
                    String nome;
                    int cpf;
                    String formacao;
                    System.out.println("Digite o CPF (11 digitos):");
                    cpf = leitor.nextInt();
                    leitor.nextLine();
                    boolean check = false;
                    for (int i = 0; i < entidades.size(); i++) {
                        if (entidades.get(i).getId() == cpf) {
                            System.out.println("Id j?? existente!!");
                            check = true;
                            break;
                        }
                    }
                    if (check) {
                        continue;
                    }
                    System.out.println("Digite o Nome:");
                    nome = leitor.nextLine();

                    System.out.println("Digite a Forma????o:");
                    formacao = leitor.nextLine();

                    Professor newProf = new Professor(cpf, nome, cpf, formacao);
                    entidades.add(newProf);
                    undoList.add("add:prof:undo");
                    newProf.Ver_info();
                }

                //editar infos
                else if (option == 2) {
                    String nome;
                    int choice;
                    String formacao;
                    Boolean check = false;
                    System.out.print("Digite o ID do professor: ");
                    id = leitor.nextInt();

                    for (int i = 0; i < entidades.size(); i++) {
                        if (entidades.get(i) instanceof Professor) {
                            if (entidades.get(i).getId() == id) {
                                profExample = (Professor) entidades.get(i);
                                check = true;
                                break;
                            }
                        }
                    }
                    if (!check) {
                        System.out.println("o professor n??o existe!!");
                    }
                    System.out.println("Qual informa????o deseja editar?\n");
                    System.out.println("[1] - Nome");
                    System.out.println("[2] - CPF");
                    System.out.println("[3] - Forma????o\n>>");
                    option = leitor.nextInt();

                    entidades_pre_edicao.add(profExample.clone());

                    if (option == 1) {
                        System.out.println("Digite o novo Nome:\n>>");
                        nome = leitor.next();
                        profExample.setNome(nome);
                    } else if (option == 2) {
                        System.out.println("Digite o novo CPF:\n>>");
                        choice = leitor.nextInt();
                        profExample.setCpf(choice);
                        profExample.setId(choice);
                    } else if (option == 3) {
                        System.out.println("Digite a nova forma????o:\n>>");
                        formacao = leitor.next();
                        profExample.setFormacao(formacao);
                    }
                    undoList.add("edit:prof:undo");
                    profExample.Ver_info();
                }

                //ver infos
                else if (option == 3) {
                    System.out.print("Digite o CPF do professor: ");
                    id = leitor.nextInt();
                    boolean check = false;
                    for (int i = 0; i < entidades.size(); i++) {
                        if (entidades.get(i) instanceof Professor) {
                            if (entidades.get(i).getId() == id) {
                                check = true;
                                profExample = (Professor) entidades.get(i);
                                profExample.Ver_info();
                                break;
                            }
                        }
                    }
                    if (!check) {
                        System.out.println("Professor n??o encontrado!!\n");
                    }
                }

                //Remover Professor
                else if (option == 4) {
                    System.out.print("Digite o CPF do professor: ");
                    id = leitor.nextInt();
                    for (int i = 0; i < entidades.size(); i++) {
                        if (entidades.get(i) instanceof Professor) {
                            if (entidades.get(i).getId() == id) {
                                profExample = (Professor) entidades.get(i);
                                entidades_removidas.add(profExample.clone());
                                entidades.remove(i);
                                System.out.println("Professor removido.");
                                undoList.add("rm:prof:undo");
                                break;
                            }
                        }
                    }
                }
            }

            // ALUNO
            else if (x == 3) {
                int id;
                Aluno alunoExample = new Aluno(0, null, 1, null, 0);
                System.out.println("\n[1] - Cadastrar Aluno");
                System.out.println("[2] - Remover Aluno");
                System.out.println("[3] - Editar dados do Aluno");
                System.out.println("[4] - Ver informa????es do Aluno");
                System.out.println("[5] - Gerar Boletim");
                System.out.println("[6] - Gerar Hist??rico Anal??tico");
                System.out.println("[7] - Matricular aluno em disciplina");
                System.out.println("[8] - Listar disciplinas");
                System.out.println("[9] - Sair");
                x = leitor.nextInt();
                leitor.nextLine();

                // Adicionar
                if (x == 1) {
                    String nome;
                    int matricula;
                    int cpf;
                    String email;

                    System.out.print("Nome: ");
                    nome = leitor.nextLine();

                    System.out.println("Matr??cula: ");
                    matricula = leitor.nextInt();

                    System.out.println("CPF: ");
                    cpf = leitor.nextInt();
                    leitor.nextLine();

                    System.out.println("Email: ");
                    email = leitor.nextLine();

                    Aluno aluno1 = new Aluno(matricula, nome, matricula, email, cpf);
                    entidades.add(aluno1);
                    System.out.println("Aluno adicionado!\n");
                    aluno1.Ver_info();
                    undoList.add("add:aluno:undo");
                }

                // Remover
                else if (x == 2) {
                    System.out.println("Matr??cula do aluno: ");
                    id = leitor.nextInt();
                    for (int i = 0; i < entidades.size(); i++) {
                        if (entidades.get(i) instanceof Aluno) {
                            if (entidades.get(i).getId() == id) {
                                alunoExample = (Aluno) entidades.get(i);
                                entidades_removidas.add(alunoExample.clone());
                                entidades.remove(i);
                                System.out.println("Aluno removido!\n");
                                undoList.add("rm:aluno:undo");
                                break;
                            }
                        }
                    }
                }
                // Editar 
                else if (x == 3) {
                    System.out.println("Matr??cula do aluno: ");
                    id = leitor.nextInt();
                    boolean check = false;
                    for (int i = 0; i < entidades.size(); i++) {
                        if (entidades.get(i) instanceof Aluno) {
                            if (entidades.get(i).getId() == id) {
                                alunoExample = (Aluno) entidades.get(i);
                                check = true;
                                break;
                            }
                        }
                    }
                    if (!check) {
                        System.out.println("Aluno inexistente.");
                        continue;
                    }
                    
                    System.out.println("0 - Editar nome");
                    System.out.println("1 - Editar email");
                    System.out.println("2 - Trancar curso");
                    System.out.println("3 - Reabrir curso");

                    int aux = leitor.nextInt();

                    entidades_pre_edicao.add(alunoExample.clone());
                    if (aux == 0) {
                        System.out.println("Digite o novo nome: ");
                        String new_name = leitor.next();
                        alunoExample.setNome(new_name);
                        System.out.println("Informa????o atualizada!\n");
                    } else if (aux == 1) {
                        System.out.println("Digite o novo email: ");
                        String email = leitor.next();
                        alunoExample.setEmail(email);
                        System.out.println("Informa????o atualizada!\n");
                    } else if (aux == 2) {
                        System.out.println("Deseja continuar(S/N)?");
                        String resp = leitor.next();
                        if (resp.equals("S") || resp.equals("s")) {
                            alunoExample.setStatusCurso(false);
                            System.out.println("Informa????o atualizada!\n");
                        } else {
                            System.out.println("Opera????o cancelada.\n");
                        }
                    } else if (aux == 3) {
                        if (alunoExample.getStatusCurso() == false) {
                            System.out.println("Bem vindo(a), novamente!\n");
                            alunoExample.setStatusCurso(true);
                        }
                        System.out.println("Sua matricula nao est?? trancada\n");
                    }
                    undoList.add("edit:aluno:undo");
                }

                //Ver informa????es
                else if (x == 4) {
                    System.out.println("Matr??cula do aluno: ");
                    id = leitor.nextInt();
                    for (int i = 0; i < entidades.size(); i++) {
                        if (entidades.get(i) instanceof Aluno) {
                            if (entidades.get(i).getId() == id) {
                                entidades.get(i).Ver_info();
                                break;
                            }
                        }
                    }
                }

                //Boletim
                else if (x == 5) {
                    System.out.println("Matr??cula do aluno: ");
                    id = leitor.nextInt();
                    for (int i = 0; i < entidades.size(); i++) {
                        if (entidades.get(i) instanceof Aluno) {
                            if (entidades.get(i).getId() == id) {
                                alunoExample = (Aluno) entidades.get(i);
                                System.out.println("Boletim do aluno " + alunoExample.getNome());
                                alunoExample.setNotas("Algebra --- 4.6 --- 72h");
                                alunoExample.setNotas("logica 1 --- 7.6 --- 72h");
                                alunoExample.setNotas("Programacao 1 --- 8.6 --- 144h");
                                alunoExample.setNotas("Teoria da Computacao --- 9.6 --- 72h");
                                alunoExample.setNotas("Sistemas de Informacao --- 10.0 --- 72h");
                                alunoExample.setNotas("Calculo3 --- 5.6 --- 72h");
                                alunoExample.printBoletim();
                                break;
                            }
                        }
                    }
                }

                //Hist??rico
                else if (x == 6) {
                    System.out.println("Matr??cula do aluno: ");
                    id = leitor.nextInt();
                    for (int i = 0; i < entidades.size(); i++) {
                        if (entidades.get(i) instanceof Aluno) {
                            if (entidades.get(i).getId() == id) {
                                alunoExample = (Aluno) entidades.get(i);
                                alunoExample.setHistoricoAnalitico("Carga Hor??ria Cumprida --- 720h");
                                alunoExample.setHistoricoAnalitico("Coeficiente de Rendimento --- 82.48%");
                                alunoExample.setHistoricoAnalitico("1?? per??odo --- Programa????o 1 --- 7.3 --- AP");
                                alunoExample.setHistoricoAnalitico("1?? per??odo --- Matem??tica Discreta --- 9.4 --- AP");
                                alunoExample.setHistoricoAnalitico("2?? per??odo --- Banco de Dados --- 10 --- AP");
                                alunoExample.setHistoricoAnalitico("2?? per??odo --- Estrutura de Dados --- 9.4 --- AP");
                                alunoExample.setHistoricoAnalitico("3?? per??odo --- ??lgebra Linear --- 5.7 --- AP");
                                alunoExample.setHistoricoAnalitico("3?? per??odo --- Teoria dos Grafos --- 3.1 --- REP");
                                alunoExample.setHistoricoAnalitico("Eletiva --- Sistemas Distrib??dos --- 9.2 --- AP");
                                System.out.println("Hist??rico do aluno " + alunoExample.getNome());
                                alunoExample.printHistorico();
                                break;
                            }
                        }
                    }
                }

                // Matricula
                else if (x == 7) {
                    System.out.print("Matr??cula do aluno: ");
                    id = leitor.nextInt();
                    System.out.print("Insira o nome da disciplina: ");
                    String disciplina = leitor.next();
                    for (int i = 0; i < entidades.size(); i++) {
                        if (entidades.get(i) instanceof Aluno) {
                            if (entidades.get(i).getId() == id) {
                                alunoExample = (Aluno) entidades.get(i);
                                entidades_pre_edicao.add(alunoExample.clone());
                                alunoExample.setDisciplinasAtuais(disciplina);
                                undoList.add("edit:aluno:undo");
                                System.out.println("Disciplina inserida com sucesso!");
                                break;
                            }
                        }
                    }
                }

                // Listar Disciplinas
                else if (x == 8) {
                    System.out.println("Matr??cula do aluno: ");
                    id = leitor.nextInt();
                    for (int i = 0; i < entidades.size(); i++) {
                        if (entidades.get(i).getId() == id) {
                            alunoExample = (Aluno) entidades.get(i);
                            alunoExample.printDisciplina();
                            break;
                        }
                    }
                } else if (x == 9) {
                    continue;
                } else {
                    System.out.println("Op????o n??o reconhecida, tente novamente.");
                }
            }

            // TURMA
            else if (x == 1) {
                ArrayList<String> dias1 = new ArrayList<String>();
                ArrayList<String> horarios1 = new ArrayList<String>();
                ArrayList<String> alunos1 = new ArrayList<String>();
                Turma turmaExample = new Turma(0, null, dias1, horarios1, null, alunos1);
                System.out.println("\n[1] - Adicionar turma;\n[2] - Editar dados de uma turma;\n[3] - Remover turma;\n[4] - Lista dados de uma turma;\n[5] - Listar turmas.");
                System.out.print("Selecione um dos comandos: ");
                String input;
                input = leitor.next();

                //ADICIONAR - TURMA
                if (input.equals("1")) {
                    int id;
                    String disciplina;
                    String professor;

                    System.out.println("\nInsira os dados da turma:");
                    System.out.print("ID da turma: ");
                    id = leitor.nextInt();
                    System.out.print("Disciplina da turma: ");
                    disciplina = leitor.next();
                    System.out.print("Dias de aula da turma (para parar, insira 'end'): ");
                    int i = 0;
                    while (i < 7) {
                        String value = leitor.next();
                        if (value.equals("end")) {
                            break;
                        }
                        dias1.add(value);
                        i++;
                    }
                    System.out.print("Hor??rios de aula da turma (para parar, insira 'end'): ");
                    i = 0;
                    while (i < 14) {
                        String value = leitor.next();
                        if (value.equals("end")) {
                            break;
                        }
                        horarios1.add(value);
                        i++;
                    }
                    System.out.print("Professor da turma: ");
                    professor = leitor.next();
                    System.out.print("Alunos da turma (para parar, insira 'end'): ");
                    i = 0;
                    while (i < 40) {
                        String value = leitor.next();
                        if (value.equals("end")) {
                            break;
                        }
                        alunos1.add(value);
                        i++;
                    }
                    Turma turma1 = new Turma(id, disciplina, dias1, horarios1, professor, alunos1);
                    undoList.add("add:turma:undo");
                    entidades.add(turma1);
                    System.out.println("Turma adicionada!\n");
                }
                
                //Editar TURMA
                else if (input.equals("2")) {
                    System.out.print("Informe o ID da turma que deseja editar: ");
                    int id = leitor.nextInt();
                    Boolean check = false;

                    for (int i = 0; i < entidades.size(); i++) {
                        if (entidades.get(i) instanceof Turma) {
                            if (entidades.get(i).getId() == id) {
                                turmaExample = (Turma) entidades.get(i);
                                check = true;
                                break;
                            }
                        }
                    }

                    if (!check) {
                        System.out.println("A turma informada n??o existe no sistema.\n");
                        continue;
                    }

                    entidades_pre_edicao.add(turmaExample.clone());
                    undoList.add("edit:turma:undo");

                    System.out.print(
                            "[1] - Editar disciplina;\n[2] - Editar dias de aula;\n[3] - Editar hor??rios de aula;\n[4] - Editar professor;\n[5] - Editar alunos.\nSelecione um dos comandos: ");
                    int op = leitor.nextInt();

                    if (op == 1) {
                        System.out.print("Insira o novo 'disciplina': ");
                        turmaExample.setNome(leitor.next());
                    } else if (op == 2) {
                        ArrayList<String> lista = new ArrayList<String>();
                        System.out.print("Insira os novos dias de aula da turma (para parar, insira 'end'): ");
                        int i = 0;
                        while (i < 14) {
                            String value = leitor.next();
                            if (value.equals("end")) {
                                break;
                            }
                            lista.add(value);
                            i++;
                        }
                        turmaExample.setDias(lista);
                    } else if (op == 3) {
                        ArrayList<String> lista = new ArrayList<String>();
                        System.out.print("Insira os novos hor??rios de aula da turma (para parar, insira 'end'): ");
                        int i = 0;
                        leitor.nextLine();
                        while (i < 14) {
                            String value = leitor.nextLine();
                            if (value.equals("end")) {
                                break;
                            }
                            lista.add(value);
                            i++;
                        }
                        turmaExample.setHorarios(lista);
                    } else if (op == 4) {
                        System.out.print("Insira o(a) novo(a) professor(a) da turma: ");
                        turmaExample.setProfessor(leitor.next());
                    } else if (op == 5) {
                        ArrayList<String> lista = new ArrayList<String>();
                        System.out.print("Insira os novos alunos da turma (para parar, insira 'end'): ");
                        int i = 0;
                        leitor.nextLine();
                        while (i < 14) {
                            String value = leitor.nextLine();
                            if (value.equals("end")) {
                                break;
                            }
                            lista.add(value);
                            i++;
                        }
                        turmaExample.setAlunos(lista);
                    }
                    System.out.println("Dados da turma editados com sucesso!");

                }

                //REMO????O - TURMA
                else if (input.equals("3")) {
                    System.out.print("\nInforme o ID da turma a ser removida: ");
                    int op = leitor.nextInt();
                    for (int i = 0; i < entidades.size(); i++) {
                        if (entidades.get(i) instanceof Turma) {
                            if(entidades.get(i).getId() == op){
                                turmaExample = (Turma)entidades.get(i);
                                entidades_removidas.add(turmaExample.clone());
                                undoList.add("rm:turma:undo");
                                entidades.remove(i);
                                System.out.printf("A turma %s foi removida do sistema.\n", i);
                            }
                        }
                    }
                }
                //VER INFORMA????ES - TURMA
                else if (input.equals("4")) {
                    System.out.print("\nInforme o ID da turma a ser buscada: ");
                    int src = leitor.nextInt();
                    int ne = 0;
                    for (int i = 0; i < entidades.size(); i++) {
                        if (entidades.get(i).getId() == src) {
                            entidades.get(i).Ver_info();
                            ne += 1;
                            break;
                        }
                    }
                    if (ne == 0) {
                        System.out.println("A turma informada n??o existe no sistema.");
                    }
                }

                //Listar TURMAS
                else if (input.equals("5")) {
                    System.out.println("\nTurmas cadastradas:");
                    for (int i = 0; i < entidades.size(); i++) {
                        if (entidades.get(i) instanceof Turma) {
                            System.out.printf("[%s] - %s\n", entidades.get(i).getId(), entidades.get(i).getNome());
                        }
                    }
                    System.out.println("\n");
                } else {
                    System.out.print("\nInput inv??lido.\n");
                }
            } else if (x == 4) { // UNDO
                Menu menu = new Menu();
                if (undoList.size() > 0) {
                    menu.undoRedo(undoList, redoList, entidades,entidades_removidas, entidades_pre_edicao, entidades_editadas);
                    System.out.println("Ultima opera????o desfeita!");
                } else {
                    System.out.println("N??o h?? a????es a serem desfeitas.");
                }
            } else if (x == 5) {
                Menu menu = new Menu();
                if (redoList.size() > 0) {
                    menu.undoRedo(redoList, undoList, entidades, entidades_removidas, entidades_pre_edicao, entidades_editadas);
                    System.out.println("Ultima opera????o refeita!");
                } else {
                    System.out.println("N??o h?? a????es a serem refeitas.");
                }
            }else if (x == 6) {
                break;
            }
        }
        leitor.close();
    }
}
