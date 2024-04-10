package com.pwd.ceubclinic.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pwd.ceubclinic.model.Doctor;


public interface DoctorService {
    
    ResponseEntity<List<Doctor>> listDoctor();
}
