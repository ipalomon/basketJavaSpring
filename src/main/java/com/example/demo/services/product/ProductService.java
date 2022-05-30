package com.example.demo.services.product;

import com.example.demo.entities.products.Product;
import com.example.demo.repositories.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public Product create (Product product){

        Product productCreate = productRepository.save(product);

        return productCreate;
    }

    public Iterable<Product>  getAllProducts(){
        Iterable<Product> products = productRepository.findAll();
        return products;
    }

    public Optional<Product> findProductById(Long productId){
        return productRepository.findById(productId);
    }

    public void delete(Long productId){
        productRepository.deleteById(productId);
    }

    public Product update (Product book){
        return productRepository.save(book);
    }
}
