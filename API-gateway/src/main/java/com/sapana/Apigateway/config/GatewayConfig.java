package com.sapana.Apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Sapana Rimal
 * Date: 10/28/2024
 */

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("email-service", r -> r.path("/email/**")
                        .uri("http://localhost:8084"))
                .route("order-service", r -> r.path("/api/orders/**")
                        .uri("http://localhost:8083"))
                .build();
    }
}
