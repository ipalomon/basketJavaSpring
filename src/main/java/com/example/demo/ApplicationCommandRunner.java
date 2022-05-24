package com.example.demo;

import com.example.demo.entities.products.Product;
import com.example.demo.services.product.ProductService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class ApplicationCommandRunner implements CommandLineRunner {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    ProductService productService;

    @Override
    public void run(String... args) throws Exception {

        logger.info("Welcome to the runner from commandLineRunner");


        //createProducts();

        logger.info("executing ...");

        Scanner reader = new Scanner(System.in);
        System.out.println("Reading hello Spring Boot Command Line Runner: " + reader.nextLine());
        //it works



    }

    private void createProducts(){
        // String title, String author, int pages, int year, String iSBN
        Product product = new Product(1,"Coches");
        Product product1 = new Product(2,"Motos");
        Product product2 = new Product(3,"Camiones");
        Product product3 = new Product(4,"Autobuses");

        productService.create(product);
        productService.create(product1);
        productService.create(product2);
        productService.create(product3);
    }
}
