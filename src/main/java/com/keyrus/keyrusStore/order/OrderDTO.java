package com.keyrus.keyrusStore.order;

import com.keyrus.keyrusStore.customer.CustomerModel;
import com.keyrus.keyrusStore.orderProduct.OrderProductDTO;

import java.util.List;

public class OrderDTO {

    private Long orderId;
    private CustomerModel customerModel;
    private List<OrderProductDTO> productList;
    private Double totalPrice;

    public CustomerModel getCustomerModel() {

        return customerModel;
    }

    public void setCustomerModel(CustomerModel customerModel) {

        this.customerModel = customerModel;
    }

    public Long getOrderId() {

        return orderId;
    }

    public void setOrderId(Long orderId) {

        this.orderId = orderId;
    }

    public List<OrderProductDTO> getProductList() {

        return productList;
    }

    public void setProductList(List<OrderProductDTO> productList) {

        this.productList = productList;
    }

    public Double getTotalPrice() {

        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {

        this.totalPrice = totalPrice;
    }
}
