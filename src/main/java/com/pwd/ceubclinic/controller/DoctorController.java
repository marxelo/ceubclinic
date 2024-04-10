package com.pwd.ceubclinic.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pwd.ceubclinic.model.Doctor;
import com.pwd.ceubclinic.service.DoctorService;

@RestController
public class DoctorController {

    // private ReaderService readerService;
    private DoctorService doctorService;

    private DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> helloRest() {
        return doctorService.listDoctor();
    }
}
