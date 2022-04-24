package com.example.clinica_final_backend.model.entity;

import javax.persistence.*;

@Entity
@Table (name = "address")
public class Address {
    // Attributes
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "street")
    private String street;
    @Column (name = "number")
    private String number;
    @Column (name = "city")
    private String city;
    @Column (name = "state")
    private String state;


    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

}