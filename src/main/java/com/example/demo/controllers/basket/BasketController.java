package com.example.demo.controllers.basket;

import com.example.demo.entities.basket.Basket;
import com.example.demo.entities.products.Product;
import com.example.demo.services.basket.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("basket")
public class BasketController {
    // Inject dependencies
    @Autowired
    BasketService basketservice;

    //here we are creating our end-point rest API
    @GetMapping("basket-list")
    public Iterable<Basket> getAllBaskets() {
        return basketservice.getAllBaskets();
    }

    @GetMapping("get-basket")
    public Basket findBasketById(Long basketId){
        Optional<Basket> basketFound = basketservice.findBasketById(basketId);
        return basketFound.orElse(null);
    }

    @DeleteMapping("delete-product-from-basket")
    public ResponseEntity<Product> deleteProductFromBasket(@RequestParam Long productId, @RequestParam Long basketId){
        Optional<Basket> basketFound = basketservice.findBasketById(basketId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("operation","deleteProduct");
        headers.add("version","api 1.0");

        if(basketFound.isPresent()){
            basketservice.deleteProductFromBasket(productId);
        }
        return null;
    }
}
