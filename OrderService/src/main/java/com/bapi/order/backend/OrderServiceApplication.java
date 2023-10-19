package com.bapi.order.backend;

import graphql.scalars.ExtendedScalars;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
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
public class OrderServiceApplication extends SpringBootServletInitializer {
    private static final String TAG = OrderServiceApplication.class.getSimpleName();

    public static void main(String[] args) {
        Logger.getLogger(TAG).info("OrderServiceApplication main " + Arrays.toString(args));
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        Logger.getLogger(TAG).info("OrderServiceApplication configure " + builder);
        return builder.sources(OrderServiceApplication.class);
    }

    @Bean
    public RuntimeWiringConfigurer wiringScalarLong() {
        Logger.getLogger(TAG).info("SpringServiceApplication wiringScalarLong ");
        return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.GraphQLLong);
    }
}
