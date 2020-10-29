package com.code2luv.crudspringbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String test(Model model){

        model.addAttribute("msg","right");

        return "hello";
    }
}
