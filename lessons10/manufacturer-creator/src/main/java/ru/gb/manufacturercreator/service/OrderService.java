package ru.gb.manufacturercreator.service;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.manufacturercreator.dao.OrderDao;
import ru.gb.manufacturercreator.entity.Order;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderDao orderDao;

    public Order save(Order order) {
        if (order == null)
            order = new Order();
        return orderDao.save(order);
    }

    @Transactional(readOnly = true)
    public Order findById(Long id) {
        return orderDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    public void deleteById(Long id) {
        try {
            orderDao.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error("There isn't order with id {}", id);
        }

    }

}

/*@Service
@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class OrderService {

    private final List<Order> orders;

    private Long count;

    public Order getOrder(Long id){
        Optional<Order> order = orders.stream().filter(p-> p.getId().equals(id)).findFirst();
        if (order.isPresent())
            return order.get();
        return Order.builder().id(count++).build();

    }

}*/
