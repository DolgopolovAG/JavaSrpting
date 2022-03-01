package ru.gb.manufacturercreator;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.manufacturercreator.entity.Order;
import ru.gb.manufacturercreator.entity.Product;
import ru.gb.manufacturercreator.service.OrderService;
import ru.gb.manufacturercreator.service.ProductService;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class ManufacturerController {

    private final OrderService orderService;

    private final ProductService productService;


    @PostMapping("/create")
    public ResponseEntity<? extends Order> handlePost() {
        Order savedOrder = orderService.save(null);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create("/order/" + savedOrder.getId()));
        return new ResponseEntity<>(savedOrder,httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("orderId") Long id) {
        orderService.deleteById(id);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<? extends Order> getOrder(@PathVariable("orderId") Long id) {
        Order order = orderService.findById(id);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{orderId}/{productId}")
    public ResponseEntity<?> handleAddProduct(@PathVariable("orderId") Long idOrder, @PathVariable("productId") Long idProduct) {
        Order order = orderService.findById(idOrder);
        if (order != null) {
            Product product = productService.findById(idProduct);
            if (product != null) {
                order.addProduct(product);
                orderService.save(order);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{orderId}/{productId}")
    public ResponseEntity<?> deleteProductById(@PathVariable("orderId") Long idOrder, @PathVariable("productId") Long idProduct) {
        Order order = orderService.findById(idOrder);
        if (order != null) {
            Product product = productService.findById(idProduct);
            if (product != null) {
                if (order.delProduct(product)){
                    orderService.save(order);
                    return new ResponseEntity<>(order, HttpStatus.NO_CONTENT);
                }

            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

     /*   @GetMapping("/create")
    public ManufacturerDto create() {
        return ManufacturerDto.builder()
                .manufacturerId(1L)
                .name("Company from another service")
                .build();
    }*/
}
