package com.example.demo.entities.tax;

import com.example.demo.entities.products.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Tax")
@Table(name = "TAX")
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="TAX_ID")
    private long taxId;
    private double type;

    @OneToOne(mappedBy = "tax", cascade = CascadeType.ALL)
    private Product product;

}
