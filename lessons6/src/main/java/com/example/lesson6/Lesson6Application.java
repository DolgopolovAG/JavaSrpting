package com.example.lesson6;

import com.example.lesson6.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


//@EnableConfigurationProperties(HibernateConfig.class)
@SpringBootApplication
public class Lesson6Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(Lesson6Application.class, args);
//        ProductService entityManager = run.getBean(ProductService.class);
//        System.out.println(entityManager.findAll());
    }

}
