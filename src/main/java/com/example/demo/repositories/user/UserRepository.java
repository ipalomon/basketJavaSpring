package com.example.demo.repositories.user;

import com.example.demo.entities.products.Product;
import com.example.demo.entities.users.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Users, Long> {
    Optional<Users> findProductByMail(String mail);
}
