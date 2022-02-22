package com.example.lesson7.model;

import java.util.List;
import java.util.Optional;
import com.example.lesson7.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Long>{
    Optional<Product> findById(Long id);
    List<Product> findAll (Sort sort);
}

