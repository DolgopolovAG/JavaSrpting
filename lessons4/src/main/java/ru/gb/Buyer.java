package ru.gb;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@RequiredArgsConstructor
@Component
@Scope("prototype")
public class Buyer {
    private final ShopController shopController;

    private Integer productsNumber;

    Random random = new Random();

    @PostConstruct
    public void init() {
        productsNumber = random.nextInt(9) + 2;
        shopController.enterToShop();
    }

    public void purchase() {
        System.out.println("Buyer wants to buy " + productsNumber + " products");
        int i = 0;
        while (i < productsNumber) {
            shopController.addProductToCartById(random.nextInt(5));
            i++;
        }
        int getOutProductId = random.nextInt(5);
        System.out.println("Buyer wants to get out product with id: " + getOutProductId);
        shopController.deleteProductFromCartById(getOutProductId);
    }

    public void showCart() {
        System.out.println("Buyer bought: ");
        shopController.showProductInCart();
        System.out.println("------------------------------------------------------------------------------------");
    }

}
