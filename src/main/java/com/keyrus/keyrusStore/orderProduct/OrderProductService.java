package com.keyrus.keyrusStore.orderProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class OrderProductService {

    @Autowired
    private IOrderProductRepository iOrderProductRepository;



    public String deleteOrderProduct(OrderProductModel orderProductModel) {

        iOrderProductRepository.delete(orderProductModel);
        return "Deleted";
    }


    public OrderProductModel updateOrderProduct(OrderProductModel orderProductModel) {

        return iOrderProductRepository.save(orderProductModel);

    }


    public OrderProductModel createOrderProduct(OrderProductModel orderProductModel) {

        return iOrderProductRepository.save(orderProductModel);

    }

    public Iterable<OrderProductModel> createOrderProductAll(Iterable<OrderProductModel> orderProductModels){
        return iOrderProductRepository.save(orderProductModels);
    }


    public OrderProductModel readById(Long id) {

        return iOrderProductRepository.findOne(id);
    }


    public Iterable<OrderProductModel> readAll() {

        return iOrderProductRepository.findAll();
    }


    public Iterable<OrderProductModel> readByOrderId(Long id) {

        return iOrderProductRepository.findByOrderId(id);

    }


    public Iterable<OrderProductModel> readByProductId(Long id) {

        return iOrderProductRepository.findByProductId(id);
    }
}
