package ru.gb.lessons10.entity;


import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    private Long id;

    private String status = "not empty";

    private Set<Product> products = new HashSet<>();

}