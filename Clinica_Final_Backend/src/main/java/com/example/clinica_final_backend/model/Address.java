package com.example.clinica_final_backend.model;

public class Address {
    private Integer id;
    private String street;
    private String number;
    private String city;
    private String state;

    public Address(Integer id, String street, String number, String city, String state) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
    }

    public Address(String street, String number, String city, String state) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id: " + id +
                ", street: '" + street + '\'' +
                ", number: '" + number + '\'' +
                ", city: '" + city + '\'' +
                ", state: '" + state + '\'' +
                '}';
    }

}