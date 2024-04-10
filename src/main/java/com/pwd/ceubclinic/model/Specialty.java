package com.pwd.ceubclinic.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Specialty {
    private String name;
    private String[] doctors;
}
