package com.pwd.ceubclinic.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Doctor {
    
    private String name;
    private String[] specialties;
}
