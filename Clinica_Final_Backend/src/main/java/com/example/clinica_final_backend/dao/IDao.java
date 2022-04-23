package com.example.clinica_final_backend.dao;

import java.util.List;

public interface IDao<T>{

    T register(T odontologists);
    T findById(Integer id);
    List<T> showAll();
}
