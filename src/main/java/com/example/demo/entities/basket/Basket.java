package com.example.demo.entities.basket;

import com.example.demo.entities.products.Product;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name="USER_ID")
    private int userId;
    @Column(name="QUANTITY")
    private double quantity;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL )
    private List<Product> products = new ArrayList<>();


    public void addProducts(Product product) {
        this.getProducts().add(product);
        if (product.getBasket() != null) product.getBasket().getProducts().remove(product);
        product.setBasket(this);
    }
}
