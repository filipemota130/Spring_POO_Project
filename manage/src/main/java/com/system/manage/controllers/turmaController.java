package com.system.manage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @PostMapping("turma_form")
    public ModelAndView cadastro_turma(@RequestParam("id") Integer id, @RequestParam("nome") String nome,
            @RequestParam("academic") String professor, @RequestParam("list") String alunos,
            @RequestParam("code") String horarios, @RequestParam("bool") boolean monitor) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        Turma savior = new Turma();
        savior.setId(id);
        savior.setNome(nome);
        savior.setAcademicalInfo(professor);
        savior.setCode(horarios);
        String[] new_alunos = alunos.split(";");
        for (int i = 0; i < new_alunos.length; i++) {
            savior.setList(new_alunos[i]);
        }
        savior.setBool(monitor);
        repo.save(savior);
        return mv;
    }

    @GetMapping("/list_turma")
    public ModelAndView listagemTurmas() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/Turma_List");
        mv.addObject("turmasList", repo.findAll());
        return mv;
    }

        @GetMapping(value="/alterar_turma/{id}")
    public ModelAndView alterar(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forms/alterar_turma_page");
        Turma turma = repo.getReferenceById(id);
        mv.addObject("turma", turma);
        return mv;
    }

        @PostMapping("/alterar_turma")
    public ModelAndView alterar(Turma turma) {
        ModelAndView mv = new ModelAndView();
        repo.save(turma);
        mv.setViewName("redirect:/list_turma");
        return mv;
    }

    @GetMapping("/remover_turma/{id}")
    public String excluirTurma(@PathVariable("id") Integer id) {
        repo.deleteById(id);
        return "redirect:/list_turma";
    }
}