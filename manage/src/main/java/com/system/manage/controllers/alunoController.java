package com.system.manage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.system.manage.command.Command;
import com.system.manage.command.alunoCommands.DeletarAlunoCommand;
import com.system.manage.command.alunoCommands.RegistrarAlunoCommand;
import com.system.manage.models.aluno.Aluno;
import com.system.manage.models.aluno.Boletim.Boletim;
import com.system.manage.models.aluno.HistoricoAnalitico.historicoAnalitico;
import com.system.manage.repositories.alunoRepository;

import jakarta.persistence.EntityNotFoundException;

@Controller
public class alunoController{

    @Autowired
    alunoRepository repo;

    Command<alunoRepository> slot;

    public void setCommand(Command<alunoRepository> comando) {
        this.slot = comando;
    }

    public void CommandSelected(){
        slot.execute(this.repo);
    }
    
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


    @PostMapping("/CriareAlterarAluno")
    public ModelAndView CriareAlterar(@RequestParam("id") Long id, @RequestParam("nome") String nome,
            @RequestParam("academic") String curso, @RequestParam("code") String cpf,
            @RequestParam("list") String notas, @RequestParam("pagas") String pagas,
            @RequestParam("bool") boolean status, @RequestParam("form") String form_type){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        if (form_type.equals("alterar")) {
            if (repo.findById(id).isPresent() == false) {
                mv.setViewName("home/index");
                mv.addObject("nao_existente", true);
                return mv;
            }
            mv.addObject("nao_existente", false);
        } 
        else {
            if (repo.findById(id).isPresent() == true) {
                mv.setViewName("home/index");
                mv.addObject("id_existente", true);
                return mv;
            }
            mv.addObject("id_existente", false);
        }
        try{
            RegistrarAlunoCommand RegistrarAlunoCommand = new RegistrarAlunoCommand(id, nome, curso, cpf, notas, pagas, status);
            setCommand(RegistrarAlunoCommand);
            CommandSelected();
        }
        catch(CannotCreateTransactionException e){
            mv.setViewName("home/500");
            return mv;
        }        
        return mv;
    } 
    
    @GetMapping("/remover_aluno/{id}")
    public ModelAndView excluirAluno(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("redirect:/list_aluno");
            DeletarAlunoCommand DeletarAlunoCommand = new DeletarAlunoCommand(id);
            setCommand(DeletarAlunoCommand);
            CommandSelected();
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