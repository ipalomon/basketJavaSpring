package com.example.demo.entities.users;

import com.example.demo.entities.basket.Basket;
import com.example.demo.entities.products.Product;
import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity(name="Users")
@Table(name = "USERS")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USER_ID")
    private long userId;
    private String name;
    private String surname;
    private String lastname;
    private String phone;
    private String mail;
    private String passwd;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Basket basket;

    public Users(String name, String surname, String lastname, String phone, String mail, String passwd, Basket basket) {
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.phone = phone;
        this.mail = mail;
        this.passwd = passwd;
        this.basket = basket;
    }
}
