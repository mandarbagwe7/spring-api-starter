package com.codewithmosh.store.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello Admin";
    }

}
