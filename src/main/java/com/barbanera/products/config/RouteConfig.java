package com.barbanera.products.config;

import com.barbanera.products.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class RouteConfig {

    private final ProductService productService;

    @Bean
    RouterFunction<ServerResponse> routes() {
        return route()
                .GET("/", productService::home)
                .POST("/add", productService::add)
                .build();
    }
}
