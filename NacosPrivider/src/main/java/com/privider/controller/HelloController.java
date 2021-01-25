package com.privider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/helloNacos")
    public String hello(){
        return "helloNacos";

    }
}
