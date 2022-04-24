package com.example.clinica_final_backend.repository;

import com.example.clinica_final_backend.model.entity.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointments, Long> {
}
