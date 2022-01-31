package lesson3.repository;

import lesson3.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {

    List<Product> allProd= new ArrayList<Product>();
    int count = 0;


    public Product save (Product product) {
        product.setId(count++);
        allProd.add(product);
        return product.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .build();
    }

    public  Product edit(Product product) {
        return allProd.set(product.getId(), product);
    }

    public Optional<Product> findById(Integer id) {
        if (id < allProd.size()) {
            return Optional.of(allProd.get(id));
        } else {
            return Optional.empty();
        }
    }

    public List<Product> findAll() {
        return new ArrayList<>( allProd);
    }

    public  void deleteById(Integer id) {
        if (id < allProd.size()) {
            allProd.remove(id.intValue());
        }
    }
}
