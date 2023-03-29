package com.system.manage.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.system.manage.models.aluno.Aluno;
import com.system.manage.repositories.alunoRepository;

@Controller
public class alunoController {

    @Autowired
    alunoRepository repo;

    @GetMapping("/alunos")
    public ModelAndView aluno_form(Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forms/aluno_form");
        mv.addObject("aluno", new Aluno());
        return mv;
    }

    @PostMapping("aluno_form")
    public ModelAndView cadastro_aluno(@RequestParam("id") Integer id, @RequestParam("nome") String nome,
            @RequestParam("academic") String curso, @RequestParam("code") String cpf,
            @RequestParam("list") String notas, @RequestParam("bool") boolean status) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        Aluno savior = new Aluno();
        savior.setId(id);
        savior.setNome(nome);
        savior.setAcademicalInfo(curso);
        savior.setCode(cpf);
        String[] new_notas = notas.split(";");
        for (int i = 0; i < new_notas.length; i++) {
            savior.setList(new_notas[i]);
        }
        savior.setBool(status);
        repo.save(savior);
        return mv;
    }

    @GetMapping("/list_aluno")
    public ModelAndView listagemProfs() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/Aluno_List");
        mv.addObject("alunosList", repo.findAll());
        return mv;
    }

    @GetMapping(value = "/alterar_aluno/{id}")
    public ModelAndView alterar_alunos(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forms/alterar_aluno_page");
        Optional<Aluno> aluno = repo.findById(id);
        mv.addObject("aluno", aluno);
        return mv;
    }

    @PostMapping("/alterar_aluno")
    public ModelAndView alterar_alunos(Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        repo.save(aluno);
        mv.setViewName("redirect:/list_aluno");
        return mv;
    }

    @GetMapping("/remover_aluno/{id}")
    public String excluirAluno(@PathVariable("id") Integer id) {
        repo.deleteById(id);
        return "redirect:/list_aluno";
    }

}
