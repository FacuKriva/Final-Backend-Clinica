package com.example.clinica_final_backend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "address")
@Getter
@Setter

public class Address {

    // Attributes
    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private String number;
    private String city;
    private String state;

    // Associations
    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnore
    private Patient patient;


}