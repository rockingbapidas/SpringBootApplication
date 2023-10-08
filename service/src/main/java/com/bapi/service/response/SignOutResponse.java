package com.bapi.service.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignOutResponse {
    private boolean success;
}
