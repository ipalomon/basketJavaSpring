package com.example.demo.repositories.tax;


import com.example.demo.entities.tax.Tax;
import org.springframework.data.repository.CrudRepository;

public interface TaxRepository extends CrudRepository<Tax, Long> {
}
