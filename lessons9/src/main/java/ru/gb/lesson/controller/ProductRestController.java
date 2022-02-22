package ru.gb.lesson.controller;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson.entity.Cart;
import ru.gb.lesson.entity.Product;
import ru.gb.lesson.service.CartService;
import ru.gb.lesson.service.ProductService;

import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductRestController {

    private final ProductService productService;

    private final CartService cartService;

    @GetMapping("/all")
    public List<Product> getProductList() {
        return productService.findAll();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<? extends  Product>  getProduct(@PathVariable("productId") Long id) {
        if (id != null) {
            Product product = productService.findById(id);
            if(product != null) {
                return  new ResponseEntity<>(product, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Product product){
        Product saveProduct = productService.save(product);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create("/api/v1/product" + saveProduct.getId()));
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);

    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> upadteProduct(@PathVariable("productId") Long id, @RequestBody Product product) {
        product.setId(id);
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("productId") Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/cart")
    public Set<Product> getCartList() {
        return getCurrentCart().getProducts();
    }

    @PostMapping("/cart/{productId}")
    public ResponseEntity<?> addProductInCart(@PathVariable("productId") Long id){
        Cart cart = getCurrentCart();
        Product product = productService.findById(id);
        cart.addProduct(product);
        cartService.save(cart);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @DeleteMapping("/cart/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductInCart(@PathVariable("productId") Long id) {
        Cart cart = getCurrentCart();
        Product product = productService.findById(id);
        cart.delProduct(product);
        cartService.save(cart);
    }

    public Cart getCurrentCart(){
        return cartService.findById(1L); // создана одна корзина
    }
}
