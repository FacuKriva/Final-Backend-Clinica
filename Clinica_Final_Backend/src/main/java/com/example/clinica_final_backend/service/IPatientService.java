package com.example.clinica_final_backend.service;

import com.example.clinica_final_backend.model.PatientDTO;

import java.util.Set;

public interface IPatientService {

    PatientDTO addNewPatient(PatientDTO patientDTO);
    PatientDTO searchPatientById(Long id);
    Set<PatientDTO> searchAllPatients();
    void updatePatient(PatientDTO patientDTO);
    void removePatient(Long id);
}
