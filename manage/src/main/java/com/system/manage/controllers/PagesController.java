package com.system.manage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.system.manage.repositories.professorRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class PagesController {
    
    @Autowired
    professorRepository repo;
    
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        return mv;
    }

    @GetMapping("/professor")
    public ModelAndView professor_form() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forms/professor_form");
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

}