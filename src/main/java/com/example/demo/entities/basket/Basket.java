package com.example.demo.entities.basket;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@Getter @Setter
@ToString
@AllArgsConstructor
@Entity(name="Basket")
@Table(name = "BASKET")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="BASKET_ID")
    private int basketId;
    @Column(name="PRODUCT_ID")
    private int productId;
    @Column(name="USER_ID")
    private int userId;
}
