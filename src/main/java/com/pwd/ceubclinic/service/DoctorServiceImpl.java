package com.pwd.ceubclinic.service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pwd.ceubclinic.model.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Override
    // @Transactional
    public ResponseEntity<List<Doctor>> listDoctor() {

        ObjectMapper mapper = new ObjectMapper();

        // 1. convert JSON array to Array objects
        try {
            File file = new ClassPathResource("data/doctors.json").getFile();
            // Doctor[] pp1 = mapper.readValue(json, Doctor[].class);
            List<Doctor> doctors = Arrays.asList(mapper.readValue(file, Doctor[].class));

            return ResponseEntity.status(HttpStatus.OK).body(doctors);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("json reading error");
    }

}
