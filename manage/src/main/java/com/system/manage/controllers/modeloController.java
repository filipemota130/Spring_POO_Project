package com.system.manage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.system.manage.models.aluno.Aluno;
import com.system.manage.models.modelo.Modelo;
import com.system.manage.models.professor.Professor;
import com.system.manage.repositories.ModeloRepository;

@Controller
public class modeloController {
    
    @Autowired
    ModeloRepository repo;
    
    @GetMapping("/alunos")
    public ModelAndView Aluno_form(Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forms/aluno_form");
        mv.addObject("aluno", new Aluno());
        return mv;
    }
    
    @GetMapping("/professor")
    public ModelAndView professor_form(Professor professor) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forms/professor_form");
        mv.addObject("prof", new Professor());
        return mv;
    }

    @PostMapping("aluno_form")
    public ModelAndView cadastro_aluno(@RequestParam("id") Long id, @RequestParam("nome") String nome,
            @RequestParam("curso") String curso, @RequestParam("cpf") String cpf, @RequestParam("materias") String materias, @RequestParam("status") boolean status) {
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
    
    @PostMapping("professor_form")
    public ModelAndView cadastro_professor(@RequestParam("id") Long id, @RequestParam("nome") String nome,
    @RequestParam("formacao") String formacao) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        Modelo savior = new Professor();
        savior.setId(id);
        savior.setNome(nome);
        savior.setAcademicalInfo(formacao);
        savior.setCode();
        savior.setList("materia1");
        savior.setList("materia2");
        savior.setBool(false);
        repo.save(savior);
        return mv;
    }

    @PostMapping("professor_form")
    public ModelAndView cadastro_turma(@RequestParam("id") Long id, @RequestParam("nome") String nome,
            @RequestParam("formacao") String formacao) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        Modelo savior = new Professor();
        savior.setId(id);
        savior.setNome(nome);
        savior.setAcademicalInfo(formacao);
        savior.setCode("133.721.724-77");
        savior.setList("materia1");
        savior.setList("materia2");
        savior.setBool(false);
        repo.save(savior);
        return mv;
    }

}
