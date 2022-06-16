package com.example.demo.controllers.tax;

import com.example.demo.entities.tax.Tax;
import com.example.demo.services.tax.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class TaxController {
    @Autowired
    TaxService taxService;

    //here we are creating our end-point rest API
    @GetMapping("get-all-taxes")
    public Iterable<Tax> getAllTaxes() {

        return taxService.getAllTaxes();
    }
}
