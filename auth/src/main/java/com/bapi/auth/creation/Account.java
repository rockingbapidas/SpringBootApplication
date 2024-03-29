package com.bapi.auth.creation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
    private Long createdAt;
    private boolean isCreated;
    private Object account;
    private Object accountDetails;
}
