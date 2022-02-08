package com.example.lesson4_boot.repository;

import com.example.lesson4_boot.model.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Getter
@Setter
@ConfigurationProperties("shop.properties")
public class ProductRepository {

    List<Product> products;//= new ArrayList<Product>();
    int count = 3;


    public Product save (Product product) {
        product.setId(count++);
        products.add(product);
        return product.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .build();
    }

    public  Product edit(Product product) {
        return products.set(product.getId(), product);
    }

    public Optional<Product> findById(Integer id) {
        if (id < products.size()) {
            return Optional.of(products.get(id));
        } else {
            return Optional.empty();
        }
    }

    public List<Product> findAll() {
        return new ArrayList<>( products);
    }

    public  void deleteById(Integer id) {
        if (id < products.size()) {
            products.remove(id.intValue());
        }
    }
}
