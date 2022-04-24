package com.example.clinica_final_backend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "patient")
@Getter
@Setter

public class Patient {

    //Attributes

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "firstname")
    private String firstName;
    @Column (name = "last_name")
    private String lastName;
    @Column (name = "DNI")
    private Integer dni;
    @Column (name = "admission_date")
    private Date admissionDate;
    @Column (name = "address")
    private Address address;

    //Relationships
    @OneToOne (cascade = CascadeType.REMOVE)
    @JoinColumn (name = "address_id", nullable = false, updatable = false, referencedColumnName = "id",
    unique = true)
    private Address address_id;

    @OneToMany (mappedBy = "patient", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Appointments> appointments = new HashSet<>();
}
