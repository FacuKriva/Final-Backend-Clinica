package com.example.clinica_final_backend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dentist")
@Getter
@Setter
public class Dentist {

    //Attributes

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "registration_number")
    private static Integer registrationNumber;
    @Column (name = "first_name")
    private static String firstName;
    @Column (name = "last_name")
    private static String lastName;

    // Relationships

    @OneToMany (mappedBy = "dentist")
    @JsonIgnore
    private Set<Appointments> appointments = new HashSet<>();

}
