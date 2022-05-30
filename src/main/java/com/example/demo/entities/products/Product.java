package com.example.demo.entities.products;

import com.example.demo.entities.basket.Basket;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity(name="Product")
@Table(name = "PRODUCT")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PRODUCT_ID")
    private Long productId;
    //Tax_id
    @Column(name="NAME")
    private String name;
    //Description
    //Price

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BASKET_FK")
    private Basket basket;


   }
