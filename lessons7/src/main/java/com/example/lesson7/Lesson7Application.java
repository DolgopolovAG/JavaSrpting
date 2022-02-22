package com.example.lesson7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


//@EnableConfigurationProperties(HibernateConfig.class)
@SpringBootApplication
public class Lesson7Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(Lesson7Application.class, args);
//        ProductService entityManager = run.getBean(ProductService.class);
//        System.out.println(entityManager.findAll());

//         ProductDaoo prod = run.getBean(ProductDaoo.class);
//         //System.out.println(prod.findAll());
//        System.out.println(prod.findById(1L));
    }

}
