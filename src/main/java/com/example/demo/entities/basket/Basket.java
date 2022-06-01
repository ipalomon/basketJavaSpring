package com.example.demo.entities.basket;

import com.example.demo.entities.products.Product;

import com.example.demo.entities.tax.Tax;
import com.example.demo.entities.users.Users;
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
    private long basketId;
    @Column(name="QUANTITY")
    private double quantity;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_FK", nullable = false)
    private Users user;

    @ManyToMany(mappedBy = "baskets", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();

    public Basket(double quantity) {
        this.quantity = quantity;
    }
}
