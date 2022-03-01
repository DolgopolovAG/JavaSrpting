package ru.gb.manufacturercreator.entity;

import lombok.*;
//import ru.gb.manufacturercreator.dto.ProductDto;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Optional;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status = "not empty";

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "orders_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();

    public boolean addProduct(Product product) {
        return products.add(product);
    }

    public boolean delProduct(Product product) {
        if (products.contains(product))
            return products.remove(product);
        return false;
    }

    public void clearProduct() {
        products.clear();
    }
}

/*
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    private Long id;

    private List<ProductDto> products;


    public boolean addProduct(ProductDto product) {
        return products.add(product);
    }

    public boolean delProduct(ProductDto product) {
        Optional<ProductDto> productFromList = products.stream().filter(p-> p.getId().equals(product.getId())).findFirst();
        if (productFromList.isPresent())
            return products.remove(productFromList.get());
        return false;
    }

    public void clearProduct() {
        products.clear();
    }

}
*/
