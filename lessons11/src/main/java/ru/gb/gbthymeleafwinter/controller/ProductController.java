package ru.gb.gbthymeleafwinter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbthymeleafwinter.entity.Cart;
import ru.gb.gbthymeleafwinter.entity.Product;
import ru.gb.gbthymeleafwinter.service.CartService;
import ru.gb.gbthymeleafwinter.service.ProductService;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    private final CartService cartService;

    @GetMapping("/all")
    public String getProductList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }

    @GetMapping("/{productId}")
    public String info(Model model, @PathVariable(name = "productId") Long id) {
        Product product;
        if (id != null) {
            product = productService.findById(id);
        } else {
            return "redirect:/product/all";
        }
        model.addAttribute("product", product);
        return "product-info";
    }

    @GetMapping
    public String showForm(Model model, @RequestParam(name = "id", required = false) Long id) {
        Product product;

        if (id != null) {
            product = productService.findById(id);
        } else {
            product = new Product();
        }
        model.addAttribute("product", product);
        return "product-form";
    }

    @PostMapping
    public String saveProduct(Product product) {
        if(product.getDate() == null)
            product.setDate(LocalDate.of(2022,2,1));

        productService.save(product);
        return "redirect:/product/all";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam(name = "id") Long id) {
        productService.deleteById(id);
        return "redirect:/product/all";
    }

    @GetMapping("/cart")
    public String getCartList(Model model) {
        model.addAttribute("cart", getCurrentCart());
        return "product-cart";
    }

    @GetMapping("/cart/delete")
    public String deleteСartById(@RequestParam(name = "cartId") Long cartId, @RequestParam(name = "id") Long id) {
        Cart cart = cartService.findById(cartId);
        Product product = productService.findById(id);
        cart.delProduct(product);
        cartService.save(cart);
        return "redirect:/product/cart";
    }

    @GetMapping("/cart/add")
    public String deleteСartById(@RequestParam(name = "id") Long id) {
        Cart cart = getCurrentCart();
        Product product = productService.findById(id);
        cart.addProduct(product);
        cartService.save(cart);
        return "redirect:/product/all";
    }

    public Cart getCurrentCart(){
        return cartService.findById(1L); // создана одна корзина
    }




}
