package com.example.clinica_final_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentsDTO {

    private Long id;
    private LocalDateTime dateTime;

    @JsonIgnoreProperties ({"firstName"})
    private DentistDTO dentist;

    @JsonIgnoreProperties ({"dni", "admissionDate", "address"})
    private PatientDTO patient;
}
