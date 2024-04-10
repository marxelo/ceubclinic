package com.pwd.ceubclinic.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pwd.ceubclinic.model.Specialty;

public interface SpecialtyService {
    
    ResponseEntity<List<Specialty>> listSpecialty(String specialty, String doctor);
}
