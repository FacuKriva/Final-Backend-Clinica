package com.example.clinica_final_backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DentistDTO {
    private Long id;
    private Integer registrationNumber;
    private String firstName;
    private String lastName;
}
