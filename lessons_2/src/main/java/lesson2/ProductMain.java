package lesson2;

import lesson2.model.Cart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Scanner;

public class ProductMain {

    public static void main(String[] args) {
        ApplicationContext cont = new AnnotationConfigApplicationContext(ProductConfiguration.class);

        System.out.println(Arrays.toString(cont.getBeanDefinitionNames()));

        Cart crt = cont.getBean(Cart.class);

        int id = 0;
        int num = 1;
        Scanner in = new Scanner(System.in);
        do {

            System.out.println(" 0 - Выход.");
            System.out.println(" 1 - Добавить товар в корзину.");
            System.out.println(" 2 - Удалить товар в корзину.");
            System.out.println(" 3 - Создать новую корзину.");
            System.out.print("Что сделать: ");
            num = in.nextInt();

            if (num == 1) {
                System.out.print("Выберете Id товара: ");
                id = in.nextInt();
                crt.addProduct(id);
            } else if (num == 2) {
                System.out.print("Выберете Id товара: ");
                id = in.nextInt();
                crt.delProduct(id);
            } else if (num == 3) {
                crt = cont.getBean(Cart.class);
            }

        } while (num  > 0);



    }

}
