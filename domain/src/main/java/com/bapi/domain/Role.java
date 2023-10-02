package com.bapi.domain;

public enum Role {
    USER("USER"),
    ADMIN("ADMIN");
    private final String name;

    Role(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
