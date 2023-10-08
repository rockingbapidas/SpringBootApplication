package com.bapi.auth.creation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAccount {
    private String userName;
    private String password;
    private String fullName;
    private String phoneNo;
    private String picture;
    private String firstName;
    private String lastName;
    private String role;
}
