package com.example.demo.services.tax;

import com.example.demo.entities.products.Product;
import com.example.demo.entities.tax.Tax;
import com.example.demo.repositories.product.ProductRepository;
import com.example.demo.repositories.tax.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TaxService {
    @Autowired
    TaxRepository taxRepository;

    public Iterable<Tax>  getAllTaxes(){
        Iterable<Tax> Taxes = taxRepository.findAll();
        return Taxes;
    }
}
