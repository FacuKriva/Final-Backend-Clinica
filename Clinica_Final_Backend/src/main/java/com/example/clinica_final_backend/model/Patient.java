package com.example.clinica_final_backend.model;

import java.util.Date;

public class Patient {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer dni;
    private Date admissionDate;
    private Address address;


    public Patient(Integer id, String firstName, String lastName, Integer dni, Date admissionDate, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.admissionDate = admissionDate;
        this.address = address;
    }

    public Patient(String firstName, String lastName, Integer dni, Date admissionDate, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.admissionDate = admissionDate;
        this.address = address;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Integer getDni() { return dni; }
    public void setDni(Integer dni) { this.dni = dni; }

    public Date getAdmissionDate() { return admissionDate; }
    public void setAdmissionDate(Date admissionDate) { this.admissionDate = admissionDate; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    @Override
    public String toString() {
        return "Patient: " +
                "id: " + id +
                ", firstName: '" + firstName + '\'' +
                ", lastName: '" + lastName + '\'' +
                ", dni: " + dni +
                ", admissionDate: " + admissionDate +
                ", address: " + address +
                '}';
    }
}
