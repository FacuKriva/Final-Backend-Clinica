package com.example.clinica_final_backend.service;

import com.example.clinica_final_backend.model.DentistDTO;

import java.util.Set;

public interface IDentistService {

    //Add new Dentist
    DentistDTO addNewDentist (DentistDTO dentistDTO);

    //Search Dentist by ID
    DentistDTO searchDentistById (Long id);

    //Search All Dentists
    Set<DentistDTO> searchAllDentists();

    //Update Dentist by ID
    void updateDentist (Long id, DentistDTO dentistDTO);

    //Remove Dentist by ID
    void removeDentist (Long id);
}
