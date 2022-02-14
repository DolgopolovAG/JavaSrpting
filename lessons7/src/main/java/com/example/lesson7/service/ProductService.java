package com.example.lesson7.service;

import com.example.lesson7.repository.JpaProductRepository;
import com.example.lesson7.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final JpaProductRepository productEntity;

    public Product save (Product product) {

        return productEntity.save(product);
    }

    public  Product edit(Product product) {

        return productEntity.save(product);
    }

    public Product findById(Long id) {

        return productEntity.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Product> findAll() {
        return productEntity.findAll();
    }

    public  void deleteById(Long id) {

        productEntity.deleteById(id);
    }

}
