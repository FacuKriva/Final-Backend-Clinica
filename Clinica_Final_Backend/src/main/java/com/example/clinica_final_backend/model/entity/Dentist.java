package com.example.clinica_final_backend.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dentist")
@Getter
@Setter

public class Dentist {

    //Attributes
    @Id
    @GeneratedValue
    private Long id;
    private static String firstName;
    private static String lastName;
    private static Integer registrationNumber;
}
