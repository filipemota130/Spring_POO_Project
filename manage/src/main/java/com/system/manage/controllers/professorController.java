package com.system.manage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.system.manage.models.professor.Professor;
import com.system.manage.repositories.professorRepository;

@Controller
public class professorController {

    @Autowired
    professorRepository repo;

    @GetMapping("/professor")
    public ModelAndView professor_form(Professor professor) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forms/professor_form");
        mv.addObject("prof", new Professor());
        return mv;
    }

    @PostMapping("professor_form")
    public ModelAndView cadastro_professor(@RequestParam("id") Long id, @RequestParam("nome") String nome,
            @RequestParam("academic") String formacao, @RequestParam("list") String disc,
            @RequestParam("bool") Boolean status) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        try {
            if (repo.findById(id).isPresent() == true) {
                mv.setViewName("home/index");
                mv.addObject("id_existente", true);
                return mv;
            }
            mv.addObject("id_existente", false);
            Professor savior = new Professor();
            savior.setId(id);
            savior.setNome(nome);
            savior.setAcademicalInfo(formacao);
            savior.setCode(Long.toString(id));
            String[] new_disc = disc.split(";");
            for (int i = 0; i < new_disc.length; i++) {
                savior.setList(new_disc[i]);
            }
            savior.setBool(status);
            repo.save(savior);
        } catch (CannotCreateTransactionException e) {
            mv.setViewName("home/500");
            return mv;
        }
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

    @GetMapping("/alterar/{id}")
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

    @PostMapping("/alterar")
    public ModelAndView alterar(@RequestParam("id") Long id, @RequestParam("nome") String nome,
            @RequestParam("academic") String formacao, @RequestParam("list") String disc,
            @RequestParam("bool") Boolean status) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/list_prof");
        try {
            if (repo.findById(id).isPresent() == false) {
                mv.setViewName("home/index");
                mv.addObject("nao_existente", true);
                return mv;
            }
            mv.addObject("nao_existente", false);
            Professor savior = new Professor();
            savior.setId(id);
            savior.setNome(nome);
            savior.setAcademicalInfo(formacao);
            savior.setCode(Long.toString(id));
            String[] new_disc = disc.split(";");
            for (int i = 0; i < new_disc.length; i++) {
                savior.setList(new_disc[i]);
            }
            savior.setBool(status);
            repo.save(savior);
        } catch (CannotCreateTransactionException e) {
            mv.setViewName("home/500");
            return mv;
        }
        return mv;
    }

    @GetMapping("/remover/{id}")
    public ModelAndView excluirProfessor(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        try {
            repo.deleteById(id);
        } catch (CannotCreateTransactionException e) {
            mv.setViewName("home/500");
            return mv;
        }
        return mv;
    }

}