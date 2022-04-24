package com.example.clinica_final_backend.service;

import com.example.clinica_final_backend.model.AddressDTO;

import java.util.Set;

public interface IAddressService {

    AddressDTO addNewAddress (AddressDTO addressDTO);
    AddressDTO searchById (Long id);
    Set<AddressDTO> searchAll();
    void updateAddress (AddressDTO addressDTO);
    void removeAddress (Long id);
}
