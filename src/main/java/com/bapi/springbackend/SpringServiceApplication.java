package com.bapi.springbackend;

import graphql.scalars.ExtendedScalars;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;
import java.util.logging.Logger;

@SpringBootApplication
@ComponentScan({
        "com.bapi.api",
        "com.bapi.auth",
        "com.bapi.data",
        "com.bapi.domain",
        "com.bapi.service",
        "com.bapi.platform",
        "com.bapi.springbackend"
})
@EnableJpaRepositories("com.bapi.data.dao")
@EntityScan("com.bapi.data.entity")
@EnableTransactionManagement
public class SpringServiceApplication extends SpringBootServletInitializer {
    private static final String TAG = SpringServiceApplication.class.getSimpleName();

    public static void main(String[] args) {
        Logger.getLogger(TAG).info("SpringServiceApplication main " + Arrays.toString(args));
        SpringApplication.run(SpringServiceApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        Logger.getLogger(TAG).info("SpringServiceApplication configure " + builder);
        return builder.sources(SpringServiceApplication.class);
    }

    @Bean
    public RuntimeWiringConfigurer wiringScalarLong() {
        Logger.getLogger(TAG).info("SpringServiceApplication wiringScalarLong ");
        return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.GraphQLLong);
    }
}
