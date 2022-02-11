package com.example.lesson6.repository;

import com.example.lesson6.model.Product;
import com.example.lesson6.model.ProductDao;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaProductRepository implements ProductDao {

    @PersistenceContext
    private  EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return Optional.of( entityManager.createNamedQuery("Product.findById", Product.class)
                .setParameter("id", id).getSingleResult());
    }

    @Override
    @Transactional(readOnly = true)
    public String findNameById(Long id) {
        return entityManager.createNamedQuery("Product.findNameById", String.class)
                .setParameter("id", id).getSingleResult();
    }


    @Transactional
    @Override
    public Product save(Product product) {
        if (product.getId() == null){
            entityManager.persist(product);
        } else {
            entityManager.merge(product);
        }
        return product;
    }

    @Transactional
    @Override
    public Product insert(Product product) {
        entityManager.persist(product);
        return product;
    }

    @Transactional
    @Override
    public Product update(Product product) {
        entityManager.merge(product);
        return product;
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Product product = findById(id).get();
        entityManager.remove(product);
    }
}
