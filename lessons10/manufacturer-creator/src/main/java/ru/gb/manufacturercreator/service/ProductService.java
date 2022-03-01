package ru.gb.manufacturercreator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.manufacturercreator.dao.OrderDao;
import ru.gb.manufacturercreator.dao.ProductDao;
import ru.gb.manufacturercreator.entity.Order;
import ru.gb.manufacturercreator.entity.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductDao productDao;


    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productDao.findAll();
    }



}

