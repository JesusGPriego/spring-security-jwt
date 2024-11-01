package com.suleware.springboot.security.springboot_security.repositories;

import org.springframework.data.repository.CrudRepository;

import com.suleware.springboot.security.springboot_security.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
    boolean existsBySku(String sku);
}
