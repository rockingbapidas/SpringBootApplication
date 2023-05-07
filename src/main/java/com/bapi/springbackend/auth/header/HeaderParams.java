package com.bapi.springbackend.auth.header;


import java.util.Map;

import static com.bapi.springbackend.auth.header.HeaderUtils.*;

public class HeaderParams {
    private final String accessToken;
    private final String deviceType;
    private final String deviceId;

    private HeaderParams(String accessToken, String deviceType, String deviceId) {
        this.accessToken = accessToken;
        this.deviceType = deviceType;
        this.deviceId = deviceId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public static HeaderParamsBuilder builder() {
        return new HeaderParamsBuilder();
    }

    public static class HeaderParamsBuilder {
        private Map<String, String> headerMap;

        private HeaderParamsBuilder() {
        }

        public HeaderParamsBuilder setHeaders(Map<String, String> headerMap) {
            this.headerMap = headerMap;
            return this;
        }

        private String getAuthorization() {
            return headerMap.getOrDefault(AUTHORIZATION, "");
        }

        private String getDeviceType() {
            return headerMap.getOrDefault(DEVICE_TYPE, "");
        }

        private String getDeviceUniqueId() {
            return headerMap.getOrDefault(DEVICE_UNIQUE_ID, "");
        }

        public HeaderParams build() {
            return new HeaderParams(getAuthorization(), getDeviceType(), getDeviceUniqueId());
        }
    }
}
