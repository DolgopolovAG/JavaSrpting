package ru.gb.gbthymeleafwinter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.gbthymeleafwinter.entity.Cart;
import ru.gb.gbthymeleafwinter.entity.enums.Status;

import java.util.List;

public interface CartDao extends JpaRepository<Cart, Long>{

    List<Cart> findAllByStatus(Status status);
}
