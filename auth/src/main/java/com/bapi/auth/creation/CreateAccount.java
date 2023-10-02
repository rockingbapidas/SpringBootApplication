package com.bapi.auth.creation;

public class CreateAccount {
    private final String userName;
    private final String password;
    private final String fullName;
    private final String phoneNo;
    private final String picture;
    private final String firstName;
    private final String lastName;
    private final String role;

    private CreateAccount(String userName, String password, String fullName, String phoneNo, String picture, String firstName, String lastName, String role) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.picture = picture;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getPicture() {
        return picture;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }

    public static CreateAccountBuilder builder() {
        return new CreateAccountBuilder();
    }

    public static class CreateAccountBuilder {
        private String userName;
        private String password;
        private String fullName;
        private String phoneNo;
        private String picture;
        private String firstName;
        private String lastName;
        private String role;

        private CreateAccountBuilder() {

        }

        public CreateAccountBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public CreateAccountBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public CreateAccountBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public CreateAccountBuilder setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public CreateAccountBuilder setPicture(String picture) {
            this.picture = picture;
            return this;
        }

        public CreateAccountBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public CreateAccountBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public CreateAccountBuilder setRole(String role) {
            this.role = role;
            return this;
        }

        public CreateAccount build() {
            return new CreateAccount(userName, password, fullName, phoneNo, picture, firstName, lastName, role);
        }
    }
}
