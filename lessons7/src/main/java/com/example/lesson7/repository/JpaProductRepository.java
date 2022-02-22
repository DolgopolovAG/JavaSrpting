package com.example.lesson7.repository;

import com.example.lesson7.entity.Product;
import com.example.lesson7.model.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaProductRepository  {

    private final ProductDao productDao;

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Transactional(readOnly = true)
    public List<Product> findAll(Sort sort) {
        return productDao.findAll(sort);
    }

    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return productDao.findById(id);
    }

    @Transactional(readOnly = true)
    public String findNameById(Long id) {
        Product p = findById(id).orElse(null);
        if (p != null){
            return p.getTitle();
        }
        else {
            return "";
        }
    }


    @Transactional
    public Product save(Product product) {
      Product curr_product = findById(product.getId()).get();
      product = Product.builder()
               .id(product.getId())
               .title(product.getTitle())
               .cost(product.getCost())
               .date(product.getDate())
               .manuf_Id(product.getManuf_Id())
               .version(curr_product.getVersion())
               .createBy(curr_product.getCreateBy())
               .createDate(curr_product.getCreateDate())
               .lastModifiedBy(curr_product.getLastModifiedBy())
               .lastModifiedDate(curr_product.getLastModifiedDate())
               .build();
        product = productDao.save(product);
       return product;
    }


    @Transactional
    public void deleteById(Long id) {
        Product product = findById(id).get();
        productDao.delete(product);
    }
}
