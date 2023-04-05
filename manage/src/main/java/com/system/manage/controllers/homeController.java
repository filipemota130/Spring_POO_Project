package com.system.manage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.system.manage.repositories.alunoRepository;
import com.system.manage.repositories.professorRepository;
import com.system.manage.repositories.turmaRepository;



@Controller
public class homeController {
    
    @Autowired
    alunoRepository repo_aluno;

    @Autowired
    professorRepository repo_professor;

    @Autowired
    turmaRepository repo_turma;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        mv.addObject("msg", "check");
        return mv;
    }

    @GetMapping("/undo")
    public ModelAndView undo() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        return mv;
    }
}