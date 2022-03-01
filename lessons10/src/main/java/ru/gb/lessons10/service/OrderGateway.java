package ru.gb.lessons10.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.lessons10.dto.ManufacturerDto;
import ru.gb.lessons10.entity.Order;

@FeignClient(url = "localhost:8734/order", value = "orderGateway")
public interface OrderGateway {


    @GetMapping(value = "/{orderId}", produces = "application/json;charset=UTF-8")
    Order getOrder(@PathVariable("orderId") Long id);

    @PostMapping(value = "/create", produces = "application/json;charset=UTF-8")
    Order create();

    @DeleteMapping("/{orderId}")
    void delete(@PathVariable("orderId") Long id);

    @PostMapping("/{orderId}/{productId}")
    void addProduct(@PathVariable("orderId") Long idOrder, @PathVariable("productId") Long idProduct);

    @DeleteMapping("/{orderId}/{productId}")
    void deleteProduct(@PathVariable("orderId") Long idOrder, @PathVariable("productId") Long idProduct);

}
