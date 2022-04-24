package com.example.clinica_final_backend.repository;

import com.example.clinica_final_backend.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentsRepository extends JpaRepository<Appointment, Long> {
    void deleteById(Integer id);
}
