package com.example.clinica_final_backend.model.entity;

public class Dentist {

    private Integer id;
    private static Integer registrationNumber;
    private static String firstName;
    private static String lastName;

    public Dentist(Integer id, Integer registrationNumber, String firstName, String lastName) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Dentist(Integer registrationNumber, String firstName, String lastName) {
        this.registrationNumber = registrationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "\nOdontologists: "
                + "\nId: " + id
                + "\nRegistrationNumber: " + registrationNumber
                + "\nName: " + firstName
                + "\nLast name: " + lastName
                + "\n";
    }

    public Integer getId() { return id;}
    public void setId(Integer id) { this.id = id; }

    public static Integer getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(Integer registrationNumber) { this.registrationNumber = registrationNumber;}

    public static String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public static String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
}
