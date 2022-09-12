package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {

    @RequestMapping("/")
    public String index(){
        return "main";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
