package com.example.demo.entities.tax;

import com.example.demo.entities.products.Product;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    public Tax(double type) {
        this.type = type;
    }


}
