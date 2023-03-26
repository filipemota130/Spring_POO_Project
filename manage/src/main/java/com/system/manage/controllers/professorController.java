package com.system.manage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ModelAndView cadastro(@RequestParam("id") Long id, @RequestParam("nome") String nome, @RequestParam("formacao") String formacao) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        Professor savior = new Professor();
        savior.setId(id);savior.setNome(nome);savior.setFormacao(formacao);
        repo.save(savior);
        return mv;
    }

}
