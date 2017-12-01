package com.keyrus.keyrusStore.order;

import com.keyrus.keyrusStore.customer.CustomerModel;
import com.keyrus.keyrusStore.orderProduct.OrderProductDTO;
import javax.persistence.*;
import java.util.List;

@Entity(name = "k_order")
public class OrderModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "k_order_name")
    private String orderName;
    private String description;
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "k_user_id")
    private CustomerModel customerModel;

    @Transient
    private List<OrderProductDTO> products;

    public List<OrderProductDTO> getProducts() {

        return products;
    }

    public void setProducts(List<OrderProductDTO> products) {

        this.products = products;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getOrderName() {

        return orderName;
    }

    public void setOrderName(String orderName) {

        this.orderName = orderName;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public CustomerModel getCustomerModel() {

        return customerModel;
    }

    public void setCustomerModel(CustomerModel customerModel) {

        this.customerModel = customerModel;
    }

    public Double getTotalPrice() {

        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {

        this.totalPrice = totalPrice;
    }
}
