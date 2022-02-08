package com.example.lesson4_boot.service;

import com.example.lesson4_boot.model.Product;
import com.example.lesson4_boot.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product save (Product product) {
        return productRepository.save(product);
    }

    public  Product edit(Product product) {
        return productRepository.edit(product);
    }

    public Product findById(Integer id) {
        return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public  void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

}
