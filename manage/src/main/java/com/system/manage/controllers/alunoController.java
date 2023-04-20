package com.system.manage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.system.manage.models.aluno.Aluno;
import com.system.manage.models.aluno.Boletim.Boletim;
import com.system.manage.models.aluno.HistoricoAnalitico.historicoAnalitico;
import com.system.manage.repositories.alunoRepository;

import jakarta.persistence.EntityNotFoundException;

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

    @GetMapping("/list_aluno")
    public ModelAndView listagemAlunos() {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("home/Aluno_List");
            mv.addObject("alunosList", repo.findAll());
        } catch (CannotCreateTransactionException e) {
            mv.setViewName("home/500");
            return mv;
        }
        return mv;
    }
    
    // MELHORAR A FORMA DE PEGAR OS CAMPOS DO OBJETO NO PARÂMETRO DA FUNÇÃO (TENTAR
    // PASSAR COMO PARÂMETRO O OBJETO COMPLETO AO INVÉS DE TODOS OS ATRIBUTOS)   
    @PostMapping("/CriareAlterarAluno")
    public ModelAndView CriareAlterarAluno(@RequestParam("id") Long id, @RequestParam("nome") String nome,
            @RequestParam("academic") String curso, @RequestParam("code") String cpf,
            @RequestParam("list") String notas, @RequestParam("pagas") String pagas,
            @RequestParam("bool") boolean status, @RequestParam("form") String form_type) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/list_aluno");
        try {
            if (form_type.equals("alterar")) {
                if (repo.findById(id).isPresent() == false) {
                    mv.setViewName("home/index");
                    mv.addObject("nao_existente", true);
                    return mv;
                }
                mv.addObject("nao_existente", false);
            } else {
                if (repo.findById(id).isPresent() == true) {
                    mv.setViewName("home/index");
                    mv.addObject("id_existente", true);
                    return mv;
                }
                mv.addObject("id_existente", false);
            }
            Aluno aluno = new Aluno();
            aluno.setAcademicalInfo(curso);
            aluno.setBool(status);
            aluno.setId(id);
            aluno.setNome(nome);
            aluno.setCode(cpf);
            String[] new_notas = notas.split(";");
            for (int i = 0; i < new_notas.length; i++) {
                aluno.setList(new_notas[i]);
            }
            String[] new_notas_pagas = pagas.split(";");
            for (int i = 0; i < new_notas_pagas.length; i++) {
                aluno.setDisciplinasPagas(new_notas_pagas[i]);
            }
            repo.save(aluno);
        } catch (CannotCreateTransactionException e) {
            mv.setViewName("home/500");
            return mv;
        }
        return mv;
    }
    
    @GetMapping(value = "/alterar_aluno/{id}")
    public ModelAndView alterar_alunos(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView();
        try {
            Aluno aluno = repo.getReferenceById(id);
            mv.addObject("aluno", aluno);
            mv.setViewName("forms/alterar_aluno_page");
            return mv;
        }
        catch (CannotCreateTransactionException e) {
            mv.setViewName("home/500");
            return mv;
        }
        catch (EntityNotFoundException e) {
            mv.setViewName("home/404");
            return mv;
        }
    }

    @GetMapping(value = "/boletim_aluno/{id}")
    public ModelAndView boletim_alunos(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/Boletim_page");
        try {
            Aluno aluno = repo.getReferenceById(id);
            Aluno bole = new Boletim();
            bole.setId(id);
            for (int i = 0; i < aluno.getList().size(); i++) {
                bole.setList(aluno.getList().get(i));
            }
            mv.addObject("aluno", aluno);
            mv.addObject("boletim", bole);

        }
        catch (CannotCreateTransactionException e) {
            mv.setViewName("home/500");
            return mv;
        }
        catch (EntityNotFoundException e) {
            mv.setViewName("home/404");
            return mv;
        }
        return mv;
    }

    @GetMapping(value = "/historico_aluno/{id}")
    public ModelAndView historico_alunos(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("home/Historico_page");
            Aluno aluno = repo.getReferenceById(id);
            Aluno histo = new historicoAnalitico();
            histo.setId(id);
            for (int i = 0; i < aluno.getDisciplinasPagas().size(); i++) {
                histo.setDisciplinasPagas(aluno.getDisciplinasPagas().get(i));
            }
            if (histo instanceof historicoAnalitico) {
                ((historicoAnalitico) histo).setCoeficiente(aluno.getDisciplinasPagas());
            }
            mv.addObject("aluno", aluno);
            mv.addObject("historico", histo);
        } catch (CannotCreateTransactionException e) {
            mv.setViewName("home/500");
            return mv;
        } catch (EntityNotFoundException e) {
            mv.setViewName("home/404");
            return mv;
        }
        return mv;
    }

    @GetMapping("/remover_aluno/{id}")
    public ModelAndView excluirAluno(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("redirect:/list_aluno");
            repo.deleteById(id);
        }
        catch (CannotCreateTransactionException e) {
            mv.setViewName("home/500");
            return mv;
        }
        catch (EntityNotFoundException e) {
            mv.setViewName("home/404");
            return mv;
        }
        return mv;
    }

}
