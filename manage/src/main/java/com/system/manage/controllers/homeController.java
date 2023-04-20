package com.system.manage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;

@Controller
public class homeController {
    

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        return mv;
    }

    @GetMapping("/undo")
    public ModelAndView undo() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        return mv;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView getHome() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        return mv;
    }
}