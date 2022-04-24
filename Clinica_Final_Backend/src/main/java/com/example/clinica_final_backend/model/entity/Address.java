package com.example.clinica_final_backend.model.entity;

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
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "street")
    private String street;
    @Column (name = "number")
    private String number;
    @Column (name = "city")
    private String city;
    @Column (name = "state")
    private String state;


}