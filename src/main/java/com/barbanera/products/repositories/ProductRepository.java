package com.barbanera.products.repositories;

import com.barbanera.products.entities.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, ObjectId> {
}
