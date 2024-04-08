package com.pwd.ceubclinic.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

    @GetMapping("/hello")
    public String helloRest() {
        return "Hello World";
    }
}
