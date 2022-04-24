package com.example.clinica_final_backend.repository;

import com.example.clinica_final_backend.model.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Integer> {

    Optional<Dentist> findById(Long id);
}