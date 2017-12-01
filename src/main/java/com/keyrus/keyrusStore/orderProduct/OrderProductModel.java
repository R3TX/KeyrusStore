package com.keyrus.keyrusStore.orderProduct;

import com.keyrus.keyrusStore.order.OrderModel;
import com.keyrus.keyrusStore.product.ProductModel;

import javax.persistence.*;

@Entity(name = "order_product")
public class OrderProductModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private OrderModel order;
    @ManyToOne
    private ProductModel product;
    private Long quantity;


    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public OrderModel getOrder() {

        return order;
    }

    public void setOrder(OrderModel order) {

        this.order = order;
    }

    public ProductModel getProduct() {

        return product;
    }

    public void setProduct(ProductModel product) {

        this.product = product;
    }

    public Long getQuantity() {

        return quantity;
    }

    public void setQuantity(Long quantity) {

        this.quantity = quantity;
    }
}
