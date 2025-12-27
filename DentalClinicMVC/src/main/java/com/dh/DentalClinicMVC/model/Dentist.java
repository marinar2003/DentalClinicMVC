package com.dh.DentalClinicMVC.model;

public class Dentist {

    private Integer id;

    private Integer registration;

    private String name;

    private String lastName;

    public Dentist(Integer id, String lastName, String name, Integer registration) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.registration = registration;
    }

    public Dentist(int anInt, Integer registration, String name, String lastName) {
        this.registration = registration;
        this.name = name;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRegistration() {
        return registration;
    }

    public void setRegistration(Integer registration) {
        this.registration = registration;
    }
}
