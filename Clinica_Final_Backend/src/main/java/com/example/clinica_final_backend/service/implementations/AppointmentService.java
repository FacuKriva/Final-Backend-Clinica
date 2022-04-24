package com.example.clinica_final_backend.service.implementations;

import com.example.clinica_final_backend.model.AppointmentDTO;
import com.example.clinica_final_backend.model.entity.Appointment;
import com.example.clinica_final_backend.repository.IAppointmentsRepository;
import com.example.clinica_final_backend.service.IAppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class AppointmentService implements IAppointmentService {

    private IAppointmentsRepository repository;
    private ObjectMapper mapper;

    @Autowired
    public void setRepository(IAppointmentsRepository repository) { this.repository = repository; }

    @Autowired
    public void setMapper(ObjectMapper mapper) { this.mapper = mapper; }

    @Override
    public AppointmentDTO addNewAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = mapper.convertValue(appointmentDTO, Appointment.class);
        repository.save(appointment);
        return mapper.convertValue(appointment, AppointmentDTO.class);
    }

    @Override
    public AppointmentDTO searchAppointmentById(Long id) {
        Optional<Appointment> appointment = repository.findById(id);
        AppointmentDTO appointmentDTO = null;
        if(appointment.isPresent()) {
            appointmentDTO = mapper.convertValue(appointment, AppointmentDTO.class);
        }
        return appointmentDTO;
    }

    @Override
    public Set<AppointmentDTO> searchAllAppointments() {
        List<Appointment> appointments = repository.findAll();
        Set<AppointmentDTO> appointmentDTOS = new HashSet<>();
        for (Appointment appointment : appointments) {
            appointmentDTOS.add(mapper.convertValue(appointment, AppointmentDTO.class));
        }
        return appointmentDTOS;
    }

    @Override
    public void updateAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = mapper.convertValue(appointmentDTO, Appointment.class);
        repository.save(appointment);
    }

    @Override
    public void removeAppointment(Long id) { repository.deleteById(id); }
}
