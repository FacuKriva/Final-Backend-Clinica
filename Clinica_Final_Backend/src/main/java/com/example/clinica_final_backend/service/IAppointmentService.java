package com.example.clinica_final_backend.service;

import com.example.clinica_final_backend.model.AppointmentDTO;

import java.util.Set;

public interface IAppointmentService {

    AppointmentDTO addNewAppointment(AppointmentDTO appointmentDTO);
    AppointmentDTO searchAppointmentById(Long id);
    Set<AppointmentDTO> searchAllAppointments();
    void updateAppointment(AppointmentDTO appointmentDTO);
    void removeAppointment(Long id);
}
