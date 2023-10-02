package com.bapi.service.response;

public class UserDataResponse {
    private Long id;
    private String email;
    private String fullName;
    private String phoneNo;
    private String picture;
    private String firstName;
    private String lastName;

    public UserDataResponse(Long id, String email, String fullName, String phoneNo, String picture, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.picture = picture;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
