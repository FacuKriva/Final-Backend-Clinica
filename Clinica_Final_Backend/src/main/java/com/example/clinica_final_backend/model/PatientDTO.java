package com.example.clinica_final_backend.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class PatientDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer dni;
    private Date admissionDate;
    private Set<AddressDTO> addresses;
}
