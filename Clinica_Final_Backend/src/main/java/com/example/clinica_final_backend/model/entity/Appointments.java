package com.example.clinica_final_backend.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "appointments")
@Getter
@Setter
public class Appointments {

    // Attributes

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "date_time")
    private LocalDateTime dateTime;


    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false, referencedColumnName = "id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false, referencedColumnName = "id")
    private Dentist dentist;

}
