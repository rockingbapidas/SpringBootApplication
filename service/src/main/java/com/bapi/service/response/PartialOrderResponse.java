package com.bapi.service.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartialOrderResponse {
    private String orderId;
    private Long createdAt;
}
