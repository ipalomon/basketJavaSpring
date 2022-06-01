package com.example.demo.entities.products;

import com.example.demo.entities.basket.Basket;
import com.example.demo.entities.tax.Tax;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity(name="Product")
@Table(name = "PRODUCT")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PRODUCT_ID")
    private long productId;
    @Column(name="NAME")
    private String name;
    //Description
    private String description;
    //Price
    private double price;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TAX_FK", nullable = false)
    private Tax tax;


    @ManyToMany
    @JoinTable(name = "BASKET_PRODUCT",
            joinColumns = @JoinColumn(name = "PRODUCT_FK"),
            inverseJoinColumns = @JoinColumn(name = "BASKET_FK"))
    private List<Basket> baskets = new ArrayList<>();

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
