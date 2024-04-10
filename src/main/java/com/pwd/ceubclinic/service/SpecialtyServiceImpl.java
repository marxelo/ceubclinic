package com.pwd.ceubclinic.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pwd.ceubclinic.model.Specialty;

@Service
public class SpecialtyServiceImpl implements SpecialtyService{

    @Override
    public ResponseEntity<List<Specialty>> listSpecialty(String specialtyName, String doctorName) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            File file = new ClassPathResource("data/specialties.json").getFile();

            List<Specialty> specialties = Arrays.asList(mapper.readValue(file, Specialty[].class));

            List<Specialty> filteredSpecialties = new  ArrayList<>();

            if ( specialtyName != null && !specialtyName.trim().isEmpty()) {
                
                for (Specialty specialty : specialties) {
                    if (specialty.getName().toLowerCase().contains(specialtyName.toLowerCase().trim())) {
                        filteredSpecialties.add(specialty);
                    }
                    
                }
                specialties = filteredSpecialties;

            }

            if (doctorName != null && !doctorName.trim().isEmpty()) {
                filteredSpecialties = new  ArrayList<>();

                for (Specialty specialty : specialties) {
                    List<String> filteredDoctors = new ArrayList<>();
                
                    // Find doctors that match the search string
                    for (String doctor : specialty.getDoctors()) {
                        if (doctor.toLowerCase().contains(doctorName.toLowerCase().trim())) {
                            filteredDoctors.add(doctor);
                        }
                    }
                
                    // Create a new Specialty object with filtered doctors
                    if (!filteredDoctors.isEmpty()) {
                        Specialty filteredSpecialty = new Specialty();
                        filteredSpecialty.setName(specialty.getName());
                        filteredSpecialty.setDoctors(filteredDoctors.toArray(new String[0]));
                        filteredSpecialties.add(filteredSpecialty);
                    }
                }

                specialties = filteredSpecialties;
                
            }

            return ResponseEntity.status(HttpStatus.OK).body(specialties);
            
        } catch (Exception e) {
            e.printStackTrace(); 
        }


        throw new UnsupportedOperationException("json reading error");
    }
    
}
