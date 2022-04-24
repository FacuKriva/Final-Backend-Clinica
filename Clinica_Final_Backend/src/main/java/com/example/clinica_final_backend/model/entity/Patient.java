package com.example.clinica_final_backend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table (name = "patient")
@Getter
@Setter

public class Patient {

    //Attributes
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private Integer dni;
    private Date admissionDate;

    //Associations

    @OneToMany (mappedBy = "patient")
    @JsonIgnore
    private Set<Address> Addresses;
}
