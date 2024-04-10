package com.pwd.ceubclinic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pwd.ceubclinic.model.Specialty;
import com.pwd.ceubclinic.service.SpecialtyService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/specialties")
public class SpecialtyController {

    private SpecialtyService specialtyService;

    private SpecialtyController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    // curl http://localhost:8080/api/v1/specialties | json_pp
    // curl http://localhost:8080/api/v1/specialties\?specialty\=cardiologia | json_pp
    // curl http://localhost:8080/api/v1/specialties\?doctor\=ana\&specialty\=cardiologia | json_pp

    @GetMapping("")
    public ResponseEntity<List<Specialty>> listDoctorsBySpecialty(@RequestParam(required = false) String specialty,
    @RequestParam(required = false) String doctor) {
        return specialtyService.listSpecialty(specialty, doctor);
    }
    

    
    
}
