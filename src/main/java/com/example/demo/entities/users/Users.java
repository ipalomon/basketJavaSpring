package com.example.demo.entities.users;

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
    private int userId;
    @Column(name="NAME")
    private String name;
}
