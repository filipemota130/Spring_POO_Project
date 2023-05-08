package com.system.manage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.system.manage.command.Command;
import com.system.manage.command.professorCommands.DeletarProfessorCommand;
import com.system.manage.command.professorCommands.RegistrarProfessorCommand;
import com.system.manage.models.professor.Professor;
import com.system.manage.repositories.professorRepository;

@Controller
public class professorController {

    @Autowired
    professorRepository repo;

    Command<professorRepository> slot;

    public void setCommand(Command<professorRepository> comando) {
        this.slot = comando;
    }

    public void CommandSelected(){
        slot.execute(this.repo);
    }
    
    @GetMapping("/professor")
    public ModelAndView professor_form(Professor professor) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forms/professor_form");
        mv.addObject("prof", new Professor());
        return mv;
    }

    @GetMapping("/list_prof")
    public ModelAndView listagemProfs() {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("home/Prof_List");
            mv.addObject("professoresList", repo.findAll());
        } catch (CannotCreateTransactionException e) {
            mv.setViewName("home/500");
            return mv;
        }
        return mv;
    }

    @GetMapping("/alterar_professor/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("forms/alterar_prof");
            Professor prof = repo.getReferenceById(id);
            mv.addObject("prof", prof);
        } catch (CannotCreateTransactionException e) {
            mv.setViewName("home/500");
            return mv;
        }
        return mv;
    }

    // MELHORAR A FORMA DE PEGAR OS CAMPOS DO OBJETO NO PARÂMETRO DA FUNÇÃO (TENTAR
    // PASSAR COMO PARÂMETRO O OBJETO COMPLETO AO INVÉS DE TODOS OS ATRIBUTOS)
    @PostMapping("/registrar_professor")
    public ModelAndView CriareAlterarProf(@RequestParam("id") Long id, @RequestParam("nome") String nome,
    @RequestParam("academic") String formacao, @RequestParam("list") String disc,
    @RequestParam("bool") Boolean status, @RequestParam("form") String form_type) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/list_prof");
        try {
            if (form_type.equals("alterar")) {
                if (repo.findById(id).isPresent() == false) {
                    mv.setViewName("home/index");
                    mv.addObject("nao_existente", true);
                    return mv;
                }
                mv.addObject("nao_existente", false);
            } else {
                if (repo.findById(id).isPresent() == true) {
                    mv.setViewName("home/index");
                    mv.addObject("id_existente", true);
                    return mv;
                }
                mv.addObject("id_existente", false);
            }
            Command <professorRepository> RegistrarProfessorCommand = new RegistrarProfessorCommand(id, nome, formacao, disc, status);
            setCommand(RegistrarProfessorCommand);
            CommandSelected();

        } catch (CannotCreateTransactionException e) {
            mv.setViewName("home/500");
            return mv;
        }
        return mv;
    }

    @GetMapping("/remover_professor/{id}")
    public ModelAndView excluirProfessor(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("redirect:/list_prof");
            Command<professorRepository> DeletarAlunoCommand = new DeletarProfessorCommand(id);
            setCommand(DeletarAlunoCommand);
            CommandSelected();
        } catch (CannotCreateTransactionException e) {
            mv.setViewName("home/500");
            return mv;
        }
        return mv;
    }

}