package lesson3.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private Double price;
}
