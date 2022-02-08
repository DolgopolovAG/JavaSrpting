package ru.gb.entity;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "PRODUCT")
@NamedQueries({
        @NamedQuery(name = "Product.findById",
                query = "select m from Product m where m.id = :id"),
        @NamedQuery(name = "Product.findNameById",
                query = "select m.title from Product m where m.id = :id")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "COST")
    private BigDecimal cost;
    @Column(name = "DATE")
    private LocalDate date;
}
