package com.bapi.auth.creation;

public class UpdateAccount {
    private final String fullName;
    private final String phoneNo;
    private final String picture;
    private final String firstName;
    private final String lastName;

    private UpdateAccount(String fullName, String phoneNo, String picture, String firstName, String lastName) {
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.picture = picture;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public static UpdateAccountBuilder builder() {
        return new UpdateAccountBuilder();
    }

    public static class UpdateAccountBuilder {
        private String fullName;
        private String phoneNo;
        private String picture;
        private String firstName;
        private String lastName;
        private UpdateAccountBuilder() {

        }

        public UpdateAccountBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public UpdateAccountBuilder setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public UpdateAccountBuilder setPicture(String picture) {
            this.picture = picture;
            return this;
        }

        public UpdateAccountBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UpdateAccountBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UpdateAccount build() {
            return new UpdateAccount(fullName, phoneNo, picture, firstName, lastName);
        }
    }
}
