package com.example.demo.services.basket;

import com.example.demo.entities.basket.Basket;
import com.example.demo.entities.products.Product;
import com.example.demo.repositories.basket.BasketRepository;
import com.example.demo.repositories.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BasketService {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    ProductRepository productrepository;

    public Iterable<Basket>  getAllBaskets(){
        Iterable<Basket> basket = basketRepository.findAll();
        return basket;
    }

    public Optional<Basket> findBasketById(Long basketId){
        return basketRepository.findById(basketId);
    }

    public void deleteProductFromBasket(Long productId){
        productrepository.deleteById(productId);
    }
}
