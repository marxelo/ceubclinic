package com.pwd.ceubclinic.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pwd.ceubclinic.model.Doctor;
import com.pwd.ceubclinic.service.DoctorService;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private DoctorService doctorService;

    private DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // curl http://localhost:8080/api/doctors\?name\=silva\&specialty\=cardio | json_pp             
    @GetMapping("")
    public ResponseEntity<List<Doctor>> getDoctors(@RequestParam(required = false) String name,
            @RequestParam(required = false) String specialty) {
        return doctorService.listDoctor(name, specialty);
    }

}
