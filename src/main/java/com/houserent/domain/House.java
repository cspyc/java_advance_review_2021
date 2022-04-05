package com.houserent.domain;

/**
 * @author pi
 * @date 2021/03/26 17:23:37
 **/
public class House {
    private String id;
    private String owner;
    private String phoneNumber;
    private String address;
    private Double rentFare;
    private String rentStatus;

    public House(String id, String owner, String phoneNumber, String address, double rentFare, String rentStatus) {
        this.id = id;
        this.owner = owner;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.rentFare = rentFare;
        this.rentStatus = rentStatus;
    }

    public House() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRentFare(Double rentFare) {
        this.rentFare = rentFare;
    }

    public void setRentStatus(String rentStatus) {
        this.rentStatus = rentStatus;
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public Double getRentFare() {
        return rentFare;
    }

    public String getRentStatus() {
        return rentStatus;
    }

    @Override
    public String toString() {
        return id + " \t " + owner + " \t " + phoneNumber + " \t " + address + " \t " + rentFare + " \t " + rentStatus + "\t \n";
    }
}
