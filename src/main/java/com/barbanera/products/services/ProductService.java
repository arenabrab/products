package com.barbanera.products.services;

import com.barbanera.products.entities.Product;
import com.barbanera.products.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Service
public record ProductService(ProductRepository productRepository) {

    public Mono<ServerResponse> home(ServerRequest request) {
        return ok().body(Mono.fromSupplier(() -> "Welcome home!"), String.class);
    }

    public Mono<ServerResponse> add(ServerRequest request) {
        return request.bodyToMono(Product.class)
                .flatMap(productRepository::insert)
                .flatMap(prod -> ok().body(Mono.fromSupplier(() -> prod), Product.class));
    }
}
