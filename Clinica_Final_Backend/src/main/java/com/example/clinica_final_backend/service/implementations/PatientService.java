package com.example.clinica_final_backend.service.implementations;

import com.example.clinica_final_backend.model.PatientDTO;
import com.example.clinica_final_backend.model.entity.Patient;
import com.example.clinica_final_backend.repository.IPatientRepository;
import com.example.clinica_final_backend.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PatientService implements IPatientService {

    private IPatientRepository repository;
    private ObjectMapper mapper;

    @Autowired
    public void setRepository(IPatientRepository repository) { this.repository = repository; }

    @Autowired
    public void setMapper(ObjectMapper mapper) { this.mapper = mapper; }

    @Override
    public PatientDTO addNewPatient(PatientDTO patientDTO) {
        Patient patient = mapper.convertValue(patientDTO, Patient.class);
        repository.save(patient);
        return mapper.convertValue(patient, PatientDTO.class);
    }

    @Override
    public PatientDTO searchPatientById(Long id) {
        Optional<Patient> patient = repository.findById(id);
        PatientDTO patientDTO = null;
        if(patient.isPresent()) {
            patientDTO = mapper.convertValue(patient, PatientDTO.class);
        }
        return patientDTO;
    }

    @Override
    public Set<PatientDTO> searchAllPatients() {
        List<Patient> patients = repository.findAll();
        Set<PatientDTO> patientDTOS = new HashSet<>();
        for (Patient patient : patients) {
            patientDTOS.add(mapper.convertValue(patient, PatientDTO.class));
        }
        return patientDTOS;
    }

    @Override
    public void updatePatient(PatientDTO patientDTO) {
        Patient patient = mapper.convertValue(patientDTO, Patient.class);
        repository.save(patient);
    }

    @Override
    public void removePatient(Long id) {
        repository.deleteById(id);
    }
}
