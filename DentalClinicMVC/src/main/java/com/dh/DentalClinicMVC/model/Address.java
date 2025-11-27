package com.dh.DentalClinicMVC.model;

public class Address {

    private Integer id;

    private String street;

    private Integer number;

    private String location;

    private String province;

    public Address(Integer id, String province, String location, Integer number, String street) {
        this.id = id;
        this.province = province;
        this.location = location;
        this.number = number;
        this.street = street;
    }

    public Address(String street, Integer number, String location, String province) {
        this.street = street;
        this.number = number;
        this.location = location;
        this.province = province;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
