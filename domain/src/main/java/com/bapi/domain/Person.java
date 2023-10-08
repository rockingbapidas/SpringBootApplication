package com.bapi.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private Long id;
    private String userName;
    private String password;
    private Role role;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;
    private boolean enabled;
    private PersonDetails personDetails;
}
