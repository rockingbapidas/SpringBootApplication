package com.bapi.auth.backend.service.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileUpdateResponse {
    private boolean success;
}
