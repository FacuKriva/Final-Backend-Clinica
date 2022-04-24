package com.example.clinica_final_backend.model;

import com.example.clinica_final_backend.model.entity.Address;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PatientDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer dni;
    private Date admissionDate;
    private Address address;
}
