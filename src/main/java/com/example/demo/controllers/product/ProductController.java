package com.example.demo.controllers.product;

import com.example.demo.entities.products.Product;
import com.example.demo.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {
    // Inject dependencies
    @Autowired
    ProductService productservice;

    //here we are creating our end-point rest API
    @GetMapping("products-list")
    public Iterable<Product> getAllProducts() {

        return productservice.getAllProducts();
    }

    @GetMapping("get-product")
    public Product findProductById(Long productId){
        Optional<Product> productFound = productservice.findProductById(productId);
        return productFound.orElse(null);
    }

    //CRUD: create
    @PostMapping(path="add-product", consumes = "application/JSON")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        HttpHeaders headers = new HttpHeaders();
        Product productSaved = productservice.create(product);
        if(productSaved != null){
            headers.add("This product has be created", "200");
            return new ResponseEntity(productSaved, headers, HttpStatus.OK);
        }else{
            headers.add("Bat Request", "409");
            return new ResponseEntity(null, headers, HttpStatus.BAD_REQUEST);
        }
    }

    // CRUD: delete
    @DeleteMapping("delete-product")
    public ResponseEntity<Product> delete(@RequestParam Long productId){
        HttpHeaders headers = new HttpHeaders();
        headers.add("operation","deleteProduct");
        headers.add("version","api 1.0");

        Optional<Product> productOptional = productservice.findProductById(productId);
        if(productOptional.isPresent()){
            productservice.delete(productId);
            headers.add("This product has be deleted", "200");
            return new ResponseEntity(productOptional.get(), headers, HttpStatus.OK);
        }else{
            headers.add("Bat Request", "404");
            return new ResponseEntity(productOptional, headers, HttpStatus.BAD_REQUEST);
        }
    }

    //CRUD: update
    @PutMapping("update-product/{id}")
    public ResponseEntity<Product> update (@PathVariable Long id, @RequestBody Product dataProduct) {

        Optional<Product> productFound = productservice.findProductById(id);

        if (productFound.isPresent()) {
            Product productToUpdate = productFound.get();
            //
            if  (dataProduct.getName() != null) {
                productToUpdate.setName(dataProduct.getName());
            }

            Product productToUpdated = productservice.update(productToUpdate);
            return ResponseEntity.accepted().body(productToUpdated);
        } else
            return ResponseEntity.accepted().body(null);

    }
}
