package com.example.lesson4_boot;

//import com.example.lesson4_boot.config.ProductProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//@EnableConfigurationProperties(ProductProps.class)
@SpringBootApplication
public class Lesson4BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lesson4BootApplication.class, args);
    }

}
