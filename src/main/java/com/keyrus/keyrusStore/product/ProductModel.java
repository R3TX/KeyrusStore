package com.keyrus.keyrusStore.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "product")
public class ProductModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String description;
    private Double price;


    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getProductName() {

        return productName;
    }

    public void setProductName(String productName) {

        this.productName = productName;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Double getPrice() {

        return price;
    }

    public void setPrice(Double price) {

        this.price = price;
    }
}
