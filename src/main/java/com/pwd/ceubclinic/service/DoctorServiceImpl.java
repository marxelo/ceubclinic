package com.pwd.ceubclinic.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pwd.ceubclinic.model.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Override
    public ResponseEntity<List<Doctor>> listDoctor(String name, String targetSpecialty) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            File file = new ClassPathResource("data/doctors.json").getFile();
            List<Doctor> doctors = Arrays.asList(mapper.readValue(file, Doctor[].class));

            List<Doctor> filteredDoctors = new ArrayList<>();

            if (name != null) {
                for (Doctor doctor : doctors) {
                    if (doctor.getName().toLowerCase().contains(name.toLowerCase())) { // Case-insensitive search
                        filteredDoctors.add(doctor);
                    }
                }
                doctors = filteredDoctors;

            }

            if (targetSpecialty != null) {

                filteredDoctors = doctors.stream()
                        .filter(doctor -> Arrays.stream(doctor.getSpecialties())
                                .anyMatch(specialty -> specialty.toLowerCase().contains(targetSpecialty.toLowerCase())))
                        .collect(Collectors.toList());

                doctors = filteredDoctors;

            }

            return ResponseEntity.status(HttpStatus.OK).body(doctors);
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new UnsupportedOperationException("json reading error");
    }

}
