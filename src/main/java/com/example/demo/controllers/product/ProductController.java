package com.example.demo.controllers.product;

import com.example.demo.entities.products.Product;
import com.example.demo.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductService productservice;

    //here we are creating our end-point rest API
    @GetMapping("productslist")
    public Iterable<Product> getAllProducts() {

        return productservice.getAllProducts();
    }

    //CRUD: create
    @PostMapping(path="addProduct", consumes = "application/JSON")
    public Product addBook(@RequestBody Product product){


        Product productCreated = productservice.create(product);

        return productCreated ;
    }

    // CRUD: delete
    @DeleteMapping("deleteproduct")
    public ResponseEntity<Product> delete(@RequestParam Long productId){
        Optional<Product> productOptional = productservice.findProductById(productId);

    }

    // CRUD: Update
}
