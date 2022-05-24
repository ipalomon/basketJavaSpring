package com.example.demo.entities.products;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity(name="Product")
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PRODUCT_ID")
    private int productId;
    @Column(name="NAME")
    private String name;
}
