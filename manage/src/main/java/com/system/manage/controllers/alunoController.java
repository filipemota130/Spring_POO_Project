package com.system.manage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.system.manage.models.aluno.Aluno;
import com.system.manage.models.modelo.Modelo;
import com.system.manage.repositories.professorRepository;

@Controller
public class alunoController {
    
    @Autowired
    professorRepository repo;
    
    @GetMapping("/alunos")
    public ModelAndView Aluno_form(Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forms/aluno_form");
        mv.addObject("aluno", new Aluno());
        return mv;
    }

    @PostMapping("aluno_form")
    public ModelAndView cadastro(@RequestParam("id") Long id, @RequestParam("nome") String nome, @RequestParam("curso") String curso) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        Modelo savior = new Aluno();
        savior.setId(id);
        savior.setNome(nome);
        savior.setAcademicalInfo(curso);
        savior.setCode("133.721.724-77");
        savior.setList("materia1");
        savior.setList("materia2");
        savior.setBool(false);
        repo.save(savior);
        return mv;
    }

}
