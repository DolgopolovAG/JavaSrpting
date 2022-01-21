package lesson2.model;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component("Cart")
@Scope("prototype")
public class Cart {

    @Autowired
    @Qualifier("ProductRepository")
    ProductRepository repList;

    // список товаров в корзине
    List<Product> cartList;

    @PostConstruct
    void init(){
        cartList = new ArrayList<>();
        System.out.println("Корзина создана");
    }

    // добавление
    public void addProduct(int idProd){
        Product prod = getProductById(idProd);
        if (prod != null) {
            if (!cartList.contains(prod)){
                cartList.add(prod);
                System.out.println("Продукт \""+prod.name+"\" добавлен в корзину");
            } else {
                System.out.println("Продукт \""+prod.name+"\" уже находится в корзине");
            }
        }
    }

    // удалить продукт
    public void delProduct(int idProd) {
        Product prod = getProductById(idProd);
        if (prod != null) {
            if (cartList.contains(prod)){
                cartList.remove(prod);
                System.out.println("Продукт \""+prod.name+"\" удален из корзины");
            } else {
                System.out.println("Продукта \""+prod.name+"\" нет в корзине");
            }
        }

    }

    private Product getProductById (int idProd)
    {
        Product prod = repList.getProductById(idProd);
        if (prod == null) {
            System.out.println("Продукт c id =\""+idProd+"\" не найден.");
        }
        return prod;
    }

}
