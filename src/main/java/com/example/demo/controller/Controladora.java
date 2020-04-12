package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
public class Controladora {

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView model = new ModelAndView("index");
        model.addObject("message", "Hello Yose");
        return model;
    }

    @GetMapping("/contactme")
    public ModelAndView contactMe(){

        ModelAndView model = new ModelAndView("contactme");
        return model;
    }

    @GetMapping("/minesweeper")
    public ModelAndView minesweeper(){
        ModelAndView model = new ModelAndView("minesweeper");
        return  model;
    }
    @RequestMapping(value="/readm", method = RequestMethod.GET)
    public ModelAndView readm(){
        ModelAndView model = new ModelAndView("readm");
        return  model;
    }
    @RequestMapping(value="/astroport", method = RequestMethod.GET)
    public ModelAndView astroport(){
        ModelAndView model = new ModelAndView("astroport");
        return  model;
    }

}
