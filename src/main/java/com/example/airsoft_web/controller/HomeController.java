package com.example.airsoft_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/index")
    public ModelAndView register() {
        return new ModelAndView("index");
    }
}
