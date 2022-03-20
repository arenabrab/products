package com.barbanera.products.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
public record Product(int sku, BigDecimal price) {
}
