package com.example.lesson6.model;

import java.util.Optional;

public interface ProductDao {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
    String findNameById(Long id);
    Product save(Product product);
    Product insert(Product product);
    Product update(Product product);
    void deleteById(Long id);
}

