package com.example.clinica_final_backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private Long id;
    private String street;
    private String number;
    private String city;
    private String state;
}
