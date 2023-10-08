package com.bapi.service.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDataResponse {
    private Long userId;
    private String email;
    private String fullName;
    private String phoneNo;
    private String picture;
    private String firstName;
    private String lastName;
}
