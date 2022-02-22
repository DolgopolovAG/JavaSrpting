package ru.gb.lesson.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.lesson.entity.Cart;
import ru.gb.lesson.entity.enums.Status;

import java.util.List;

public interface CartDao extends JpaRepository<Cart, Long>{

    List<Cart> findAllByStatus(Status status);
}
