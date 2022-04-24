package com.example.clinica_final_backend.service;

import com.example.clinica_final_backend.dao.IDao;
import com.example.clinica_final_backend.dao.DentistDaoH2;
import com.example.clinica_final_backend.model.entity.Dentist;

import java.util.List;

public class DentistService {

    private IDao<Dentist> odontologistIDao;

    public DentistService(DentistDaoH2 dentistDaoH2){}

    public DentistService(IDao<Dentist> odontologistsIDao) { this.odontologistIDao = odontologistsIDao; }

    public IDao<Dentist> getOdontologistIDao() { return odontologistIDao; }

    public void setOdontologistIDao(IDao<Dentist> odontologistIDao) { this.odontologistIDao = odontologistIDao; }

    public Dentist findById (Integer id) { return odontologistIDao.findById(id); }

    public List<Dentist> showAll() { return odontologistIDao.showAll(); }

    public Dentist register(Dentist dentist) { return odontologistIDao.register(dentist); }
}
