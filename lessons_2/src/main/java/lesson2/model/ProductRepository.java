package lesson2.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component("ProductRepository")
@PropertySource("classpath:application.properties")
public class ProductRepository implements BeanPostProcessor {

    @Autowired
    Environment environment;

    List<Product> lProduct;

    // получить продукт по id
    public Product getProductById(int id){
        for (Product pr : lProduct) {
            if (pr.id == id)
                return pr;
        }
        return null;
    }

    @PostConstruct
    public void init() {
        lProduct = new ArrayList<>();
        System.out.println("Продуты: ");
        String[] prodAll = environment.getProperty("listProduct").split(";");
        for (String s: prodAll) {
            String[] prodPars =s.split(",");
            if (prodPars.length>2) {
                Product prod = new Product(Integer.parseInt(prodPars[0]),prodPars[1],Double.parseDouble(prodPars[2]));
                System.out.println(prod.toString());
                lProduct.add(prod);
            }
        }
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
