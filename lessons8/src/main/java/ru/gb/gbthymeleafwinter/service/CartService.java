package ru.gb.gbthymeleafwinter.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.gbthymeleafwinter.dao.CartDao;
import ru.gb.gbthymeleafwinter.entity.Cart;
import ru.gb.gbthymeleafwinter.entity.Product;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {

    private final CartDao cartDao;

    public Cart save(Cart cart) {
        return cartDao.save(cart);
    }

    @Transactional(readOnly = true)
    public Cart findById(Long id) {
        return cartDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Cart> findAll() {
        return cartDao.findAll();
    }



}
