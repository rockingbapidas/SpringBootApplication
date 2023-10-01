package com.bapi.domain;

public class PersonDetails {
    private Long id;
    private Long userId;
    private int version;
    private String fullName;
    private String phoneNo;
    private String picture;
    private String firstName;
    private String lastName;

    public PersonDetails() {
    }

    public PersonDetails(Long id, Long userId, int version, String fullName, String phoneNo, String picture, String firstName, String lastName) {
        this.id = id;
        this.userId = userId;
        this.version = version;
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.picture = picture;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonDetails(String fullName, String phoneNo, String picture, String firstName, String lastName) {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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
