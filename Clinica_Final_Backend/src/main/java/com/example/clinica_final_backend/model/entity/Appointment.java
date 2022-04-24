package com.example.clinica_final_backend.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "appointments")
@Getter
@Setter

public class Appointment {

    // Attributes
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime dateTime;

    // Associations
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

}
