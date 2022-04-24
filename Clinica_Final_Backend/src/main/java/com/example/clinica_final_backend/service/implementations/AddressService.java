package com.example.clinica_final_backend.service.implementations;

import com.example.clinica_final_backend.model.AddressDTO;
import com.example.clinica_final_backend.model.entity.Address;
import com.example.clinica_final_backend.repository.IAddressRepository;
import com.example.clinica_final_backend.service.IAddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AddressService implements IAddressService {

    private IAddressRepository repository;
    private ObjectMapper mapper;

    @Autowired
    public void setRepository(IAddressRepository repository) { this.repository = repository; }

    @Autowired
    public void setMapper(ObjectMapper mapper) { this.mapper = mapper; }

    @Override
    public AddressDTO addNewAddress(AddressDTO addressDTO) {
        Address address = mapper.convertValue(addressDTO, Address.class);
        repository.save(address);
        return mapper.convertValue(address, AddressDTO.class);
    }

    @Override
    public AddressDTO searchById(Long id) {
        Optional<Address> address = repository.findById(id);
        AddressDTO addressDTO = null;
        if(address.isPresent()) {
            addressDTO = mapper.convertValue(address, AddressDTO.class);
        }
        return addressDTO;
    }

    @Override
    public Set<AddressDTO> searchAll() {
        List<Address> addresses = repository.findAll();
        Set<AddressDTO> addressDTOS = new HashSet<>();
        for (Address address : addresses) {
            addressDTOS.add(mapper.convertValue(address, AddressDTO.class));
        }
        return addressDTOS;
    }

    @Override
    public void updateAddress(AddressDTO addressDTO) {
        Address address = mapper.convertValue(addressDTO, Address.class);
        repository.save(address);
    }

    @Override
    public void removeAddress(Long id) { repository.deleteById(id); }
}
