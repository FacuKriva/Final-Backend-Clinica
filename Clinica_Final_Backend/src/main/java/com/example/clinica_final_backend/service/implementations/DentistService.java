package com.example.clinica_final_backend.service.implementations;

import com.example.clinica_final_backend.model.DentistDTO;
import com.example.clinica_final_backend.model.entity.Dentist;
import com.example.clinica_final_backend.repository.IDentistRepository;
import com.example.clinica_final_backend.service.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DentistService implements IDentistService {

    private IDentistRepository repository;
    private ObjectMapper mapper;

    @Autowired
    public void setRepository(IDentistRepository repository) { this.repository = repository; }

    @Autowired
    public void setMapper(ObjectMapper mapper) { this.mapper = mapper; }

    @Override
    public DentistDTO addNewDentist(DentistDTO dentistDTO) {
        Dentist dentist = mapper.convertValue(dentistDTO, Dentist.class);
        repository.save(dentist);
        return mapper.convertValue(dentist, DentistDTO.class);
    }

    @Override
    public DentistDTO searchDentistById(Long id) {
        Optional<Dentist> dentist = repository.findById(id);
        DentistDTO dentistDTO = null;
        if(dentist.isPresent()) {
            dentistDTO = mapper.convertValue(dentist, DentistDTO.class);
        }
        return dentistDTO;
    }

    @Override
    public Set<DentistDTO> searchAllDentists() {
        List<Dentist> dentists = repository.findAll();
        Set<DentistDTO> dentistDTOS = new HashSet<>();
        for (Dentist dentist : dentists) {
            dentistDTOS.add(mapper.convertValue(dentist, DentistDTO.class));
        }
        return dentistDTOS;
    }

    @Override
    public void updateDentist(DentistDTO dentistDTO) {
        Dentist dentist = mapper.convertValue(dentistDTO, Dentist.class);
        repository.save(dentist);
    }

    @Override
    public void removeDentist(Long id) {
        repository.deleteById(Math.toIntExact(id));
    }

}
