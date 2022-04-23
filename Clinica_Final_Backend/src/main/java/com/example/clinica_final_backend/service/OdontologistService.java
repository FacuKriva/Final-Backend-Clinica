package com.example.clinica_final_backend.service;

import com.example.clinica_final_backend.dao.IDao;
import com.example.clinica_final_backend.dao.OdontologistDaoH2;
import com.example.clinica_final_backend.model.Odontologist;

import java.util.List;

public class OdontologistService {

    private IDao<Odontologist> odontologistIDao;

    public OdontologistService(OdontologistDaoH2 odontologistDaoH2){}

    public OdontologistService(IDao<Odontologist> odontologistsIDao) { this.odontologistIDao = odontologistsIDao; }

    public IDao<Odontologist> getOdontologistIDao() { return odontologistIDao; }

    public void setOdontologistIDao(IDao<Odontologist> odontologistIDao) { this.odontologistIDao = odontologistIDao; }

    public Odontologist findById (Integer id) { return odontologistIDao.findById(id); }

    public List<Odontologist> showAll() { return odontologistIDao.showAll(); }

    public Odontologist register(Odontologist odontologist) { return odontologistIDao.register(odontologist); }
}
