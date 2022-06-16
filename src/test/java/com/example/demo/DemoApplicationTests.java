package com.example.demo;

import com.example.demo.entities.basket.Basket;
import com.example.demo.entities.products.Product;
import com.example.demo.entities.tax.Tax;
import com.example.demo.entities.users.Users;
import com.example.demo.repositories.basket.BasketRepository;
import com.example.demo.repositories.product.ProductRepository;
import com.example.demo.repositories.tax.TaxRepository;
import com.example.demo.repositories.user.UserRepository;
import jdk.jfr.Description;
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

	//Create tables and foring keys
	@Test
	void createObjectsAndAddToBBDD(){
		Tax tax1 = new Tax(21.0);
		Tax tax2 = new Tax(10.0);
		Tax tax3 = new Tax(4.0);

		taxRepository.save(tax1);
		taxRepository.save(tax2);
		taxRepository.save(tax3);

		Users user1 = new Users("Joe","Folk","Folk","888765432","joe@folk.com","123");
		Users user2 = new Users("Jon","Smith","","556783211","jon@smith.com","123");
		Users user3 = new Users("Bean","Clinton","","987888999","bean@clinton.com","123");

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);

		Product product1 = new Product("Tenazas","Tenazas de acero con punta reforzada",26.87);
		Product product2 = new Product("Alicates","Acero inos 100/100",18.50);
		Product product3 = new Product("Alambre", "Alambre galvanizado de 20m",14.77);
		Product product4 = new Product("Corta cesped", "Potencia 300W",140.77);

		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		productRepository.save(product4);
	}

	@Test
	void assignTaxToProduct(){
		long taxId = 1;
		Product product = new Product("Llave inglesa","Llave de 3.5 mmm",16.66);
		Tax tax = new Tax(taxId,21.0, product);

		taxRepository.save(tax);

	}

	@Test
	void assignUserToBasket(){}

	@Test
	void assignProductToBasket(){}

}
