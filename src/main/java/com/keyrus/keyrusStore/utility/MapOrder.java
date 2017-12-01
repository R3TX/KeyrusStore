package com.keyrus.keyrusStore.utility;

import com.keyrus.keyrusStore.order.OrderDTO;
import com.keyrus.keyrusStore.order.OrderModel;
import org.springframework.stereotype.Component;

@Component
public class MapOrder implements MapEntity<OrderModel,OrderDTO> {

    @Override
    public OrderDTO mapToDTO(OrderModel entity) {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(entity.getId());
        orderDTO.setCustomerModel(entity.getCustomerModel());
        orderDTO.setTotalPrice(entity.getTotalPrice());

        return  orderDTO;
    }

    @Override
    public OrderModel mapToEntity(OrderDTO dto) {

        OrderModel orderModel = new OrderModel();
        orderModel.setId(dto.getOrderId());
        orderModel.setCustomerModel(dto.getCustomerModel());
        orderModel.setProducts(dto.getProductList());
        orderModel.setTotalPrice(dto.getTotalPrice());

        return orderModel;
    }
}
