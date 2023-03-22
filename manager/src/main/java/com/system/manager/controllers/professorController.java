package com.system.manager.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.system.manager.database.professorRepository;
import com.system.manager.models.modelo.Modelo;

@Controller
public class professorController {
    private final professorRepository professorRepository;

    public professorController(professorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @GetMapping("/professores")
    public ModelAndView listarProfessores() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        List<Modelo> professores = professorRepository.findAll();
        mv.addObject("professores", professores);
        return mv;
    }

}