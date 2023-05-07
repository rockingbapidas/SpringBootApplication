package com.bapi.springbackend.request;

public class ProfileUpdateRequest {
    private String fullName;
    private String phoneNo;
    private String picture;
    private String firstName;
    private String lastName;

    public ProfileUpdateRequest(String fullName, String phoneNo, String picture, String firstName, String lastName) {
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.picture = picture;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
