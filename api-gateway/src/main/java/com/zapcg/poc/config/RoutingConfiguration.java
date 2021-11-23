package com.zapcg.poc.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfiguration {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("data-dump-service", r->r.path("api/v1/producer/*")
                        .uri("http://localhost:8080"))
                .route("employee-service", r->r.path("api/v1/consumer/employee")
                        .uri("http://localhost:8081"))
                .build();
    }
}
