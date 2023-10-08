package com.bapi.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDetails {
    private String id;
    private Long userId;
    private int version;
    private String fullName;
    private String phoneNo;
    private String picture;
    private String firstName;
    private String lastName;
}
