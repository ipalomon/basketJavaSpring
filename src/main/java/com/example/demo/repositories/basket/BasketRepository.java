package com.example.demo.repositories.basket;

import com.example.demo.entities.basket.Basket;
import org.springframework.data.repository.CrudRepository;

public interface BasketRepository extends CrudRepository<Basket, Long> {
}
