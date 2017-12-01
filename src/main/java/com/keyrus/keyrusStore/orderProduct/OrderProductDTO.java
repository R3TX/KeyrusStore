package com.keyrus.keyrusStore.orderProduct;

import com.keyrus.keyrusStore.product.ProductModel;

public class OrderProductDTO {

    private ProductModel productModel;
    private Long quantity;
    private Long id;


    public ProductModel getProductModel() {

        return productModel;
    }

    public void setProductModel(ProductModel productModel) {

        this.productModel = productModel;
    }

    public Long getQuantity() {

        return quantity;
    }

    public void setQuantity(Long quantity) {

        this.quantity = quantity;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }
}
