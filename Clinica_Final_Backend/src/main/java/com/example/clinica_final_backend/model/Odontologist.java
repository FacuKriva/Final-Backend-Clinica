package com.example.clinica_final_backend.model;

public class Odontologist {

    private Long id;
    private static Integer registrationNumber;
    private static String name;
    private static String surname;

    public Odontologist(Long id, Integer registrationNumber, String name, String surname) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.surname = surname;
    }

    public Odontologist(Integer registrationNumber, String name, String surname) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "\nOdontologists: "
                + "\nId: " + id
                + "\nRegistrationNumber: " + registrationNumber
                + "\nName: " + name
                + "\nSurname: " + surname
                + "\n";
    }

    public Long getId() { return id;}
    public void setId(Long id) { this.id = id; }

    public static Integer getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(Integer registrationNumber) { this.registrationNumber = registrationNumber;}

    public static String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public static String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
}
