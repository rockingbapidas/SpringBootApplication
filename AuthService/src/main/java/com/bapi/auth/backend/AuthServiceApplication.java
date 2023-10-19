package com.bapi.auth.backend;

import graphql.scalars.ExtendedScalars;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;
import java.util.logging.Logger;

@SpringBootApplication
@ComponentScan
@EntityScan
@EnableTransactionManagement
@EnableJpaRepositories
@EnableMongoRepositories
@EnableDiscoveryClient
public class AuthServiceApplication extends SpringBootServletInitializer {
    private static final String TAG = AuthServiceApplication.class.getSimpleName();

    public static void main(String[] args) {
        Logger.getLogger(TAG).info("AuthServiceApplication main " + Arrays.toString(args));
        SpringApplication.run(AuthServiceApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        Logger.getLogger(TAG).info("AuthServiceApplication configure " + builder);
        return builder.sources(AuthServiceApplication.class);
    }

    @Bean
    public RuntimeWiringConfigurer wiringScalarLong() {
        Logger.getLogger(TAG).info("AuthServiceApplication wiringScalarLong ");
        return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.GraphQLLong);
    }
}
