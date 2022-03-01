package ru.gb.lessons10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.lessons10.entity.Order;
import ru.gb.lessons10.service.OrderGateway;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderGateway orderGateway;

    @GetMapping("/new")
    public Order GetNewOrder() {
        return orderGateway.create();
    }

    @GetMapping("/{orderId}")
    public Order GetOrder(@PathVariable("orderId") Long id) {
        return orderGateway.getOrder(id);
    }

    @PostMapping("/{orderId}/{productId}")
    public void addProduct(@PathVariable("orderId") Long idOrder, @PathVariable("productId") Long idProduct) {
        orderGateway.addProduct(idOrder, idProduct);
    }

    @DeleteMapping("/{orderId}")
    public void delete(@PathVariable("orderId") Long id){
        orderGateway.delete(id);
    }


    @DeleteMapping("/{orderId}/{productId}")
    public void deleteProduct(@PathVariable("orderId") Long idOrder, @PathVariable("productId") Long idProduct){
        orderGateway.deleteProduct(idOrder, idProduct);
    }

}
