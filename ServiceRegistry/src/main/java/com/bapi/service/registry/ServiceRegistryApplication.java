package com.bapi.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Arrays;
import java.util.logging.Logger;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication {

    private static final String TAG = ServiceRegistryApplication.class.getSimpleName();

    public static void main(String[] args) {
        Logger.getLogger(TAG).info("ServiceRegistryApplication main " + Arrays.toString(args));
        SpringApplication.run(ServiceRegistryApplication.class, args);
    }
}