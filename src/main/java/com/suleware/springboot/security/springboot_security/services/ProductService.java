package com.suleware.springboot.security.springboot_security.services;

import java.util.List;
import java.util.Optional;

import com.suleware.springboot.security.springboot_security.entities.Product;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product p);

    Optional<Product> update(Long id, Product p);

    Optional<Product> delete(Long id);

    boolean existsBySku(String sku);

}
