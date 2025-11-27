package com.dh.DentalClinicMVC.model;

import java.time.LocalDate;

public class Patient {

    private   Integer id;

    private String name;

    private String lastName;

    private Integer cardIdentity;

    private LocalDate admissionOfDate;

    private Address address;

    public Patient(Address address, LocalDate admissionOfDate, Integer cardIdentity, String lastName, String name, Integer id) {
        this.address = address;
        this.admissionOfDate = admissionOfDate;
        this.cardIdentity = cardIdentity;
        this.lastName = lastName;
        this.name = name;
        this.id = id;
    }

    public Patient(Address address, LocalDate admissionOfDate, Integer cardIdentity, String lastName, String name) {
        this.address = address;
        this.admissionOfDate = admissionOfDate;
        this.cardIdentity = cardIdentity;
        this.lastName = lastName;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCardIdentity() {
        return cardIdentity;
    }

    public void setCardIdentity(Integer cardIdentity) {
        this.cardIdentity = cardIdentity;
    }

    public LocalDate getAdmissionOfDate() {
        return admissionOfDate;
    }

    public void setAdmissionOfDate(LocalDate admissionOfDate) {
        this.admissionOfDate = admissionOfDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
