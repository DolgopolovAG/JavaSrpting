package com.example.lesson7.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "PRODUCT")
@EntityListeners(AuditingEntityListener.class)
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
    @Column(name = "MANUFACTURE_DATE")
    private LocalDate date;
    @Column(name = "MANUFACTURER_ID")
    private Long manuf_Id;

    @Version
    @Column(name = "VERSION")
    private int version;

    @CreatedBy
    @Column(name = "CREATED_BY", updatable = false)
    private String createBy;

    @CreatedDate
    @Column(name = "CREATED_DATE", updatable = false)
    private LocalDateTime createDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    private LocalDateTime lastModifiedDate;

}

