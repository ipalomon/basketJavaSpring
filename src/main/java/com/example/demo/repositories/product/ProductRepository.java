package com.example.demo.repositories.product;

import com.example.demo.entities.products.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
