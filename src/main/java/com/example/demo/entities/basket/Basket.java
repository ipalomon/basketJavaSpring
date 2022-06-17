package com.example.demo.entities.basket;

import com.example.demo.entities.products.Product;

import com.example.demo.entities.tax.Tax;
import com.example.demo.entities.users.Users;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_FK")
    private Users user;

    @ManyToMany(mappedBy = "baskets", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();

    public Basket() {}


}
