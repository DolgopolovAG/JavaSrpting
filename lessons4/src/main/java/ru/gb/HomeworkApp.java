package ru.gb;

//+1. Есть класс Product (id, название, цена). Товары хранятся в бине ProductRepository, в виде List<Product>, при старте в него нужно добавить 5 любых товаров.
//+2. ProductRepository позволяет получить весь список или один товар по id. Создаем бин Cart, в который можно добавлять, и удалять товары по id.
//3. Написать консольное приложение, позволяющее управлять корзиной.
//+4. При каждом запросе корзины из контекста, должна создаваться новая корзина.

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HomeworkApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HomeworkConfig.class);

        for (int i = 0; i < 5; i++) {
            Buyer buyer = context.getBean(Buyer.class);
            buyer.purchase();
            buyer.showCart();
        }
    }
}
