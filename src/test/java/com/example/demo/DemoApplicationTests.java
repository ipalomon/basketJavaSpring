package com.example.demo;

import com.example.demo.repositories.basket.BasketRepository;
import com.example.demo.repositories.product.ProductRepository;
import com.example.demo.repositories.tax.TaxRepository;
import com.example.demo.repositories.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	BasketRepository basketRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	TaxRepository taxRepository;

	@Test
	void createUsers() {
	}

	@Test
	void createProducts() {
	}

	@Test
	void createTax() {
	}

	@Test
	void createAddProductsToBasket(){

	}

	@Test
	void createDeleteProductsToBasket(){

	}

	@Test
	void createAddQuantityProductToBasket(){

	}

}
