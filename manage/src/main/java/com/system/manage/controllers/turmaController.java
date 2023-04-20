package com.system.manage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.system.manage.models.turma.Turma;
import com.system.manage.repositories.turmaRepository;

@Controller
public class turmaController {

    @Autowired
    turmaRepository repo;


    @GetMapping("/turma")
    public ModelAndView turma_form(Turma turma) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forms/turma_form");
        mv.addObject("turma", new Turma());
        return mv;
    }

    // MELHORAR A FORMA DE PEGAR OS CAMPOS DO OBJETO NO PARÂMETRO DA FUNÇÃO (TENTAR
    // PASSAR COMO PARÂMETRO O OBJETO COMPLETO AO INVÉS DE TODOS OS ATRIBUTOS)
    @PostMapping("/CriareAlterarTurma")
    public ModelAndView CriareAlterarTurma(@RequestParam("id") Long id, @RequestParam("nome") String nome,
    @RequestParam("academic") String professor, @RequestParam("list") String alunos,
    @RequestParam("code") String horarios, @RequestParam("bool") Boolean monitor, @RequestParam("form") String form_type) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/list_turma");
        try {
            if (form_type.equals("alterar")) {
                if (repo.findById(id).isPresent() == false) {
                    mv.setViewName("home/index");
                    mv.addObject("nao_existente", true);
                    return mv;
                }
                mv.addObject("nao_existente", false);
            } else {
                if (repo.findById(id).isPresent() == false) {
                    mv.setViewName("home/index");
                    mv.addObject("nao_existente", true);
                    return mv;
                }
            }
            mv.addObject("nao_existente", false);
        Turma turma = new Turma();
        turma.setId(id);
        turma.setNome(nome);
        turma.setAcademicalInfo(professor);
        turma.setCode(horarios);
        String[] new_alunos = alunos.split(";");
        for (int i = 0; i < new_alunos.length; i++) {
            turma.setList(new_alunos[i]);
        }
        turma.setBool(monitor);
        repo.save(turma);
        } catch (CannotCreateTransactionException e) {
                mv.setViewName("home/500");
                return mv;
            }
            return mv;
    }

    @GetMapping("/list_turma")
    public ModelAndView listagemTurmas() {
        ModelAndView mv = new ModelAndView();
        try{
            mv.setViewName("home/Turma_List");
            mv.addObject("turmasList", repo.findAll());
        }
        catch (CannotCreateTransactionException e) {
            mv.setViewName("home/500");
            return mv;
        }
        return mv;
    }

    @GetMapping(value="/alterar_turma/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("forms/alterar_turma_page");
            Turma turma = repo.getReferenceById(id);
            mv.addObject("turma", turma);
        } catch (CannotCreateTransactionException e) {
            mv.setViewName("home/500");
            return mv;
        }
        return mv;
    }

    @GetMapping("/remover_turma/{id}")
    public ModelAndView excluirTurma(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        try{
            repo.deleteById(id);
            mv.setViewName("redirect:/list_turma");
        }
        catch (CannotCreateTransactionException e) {
            mv.setViewName("home/500");
            return mv;
        }
        return mv;
    }
}