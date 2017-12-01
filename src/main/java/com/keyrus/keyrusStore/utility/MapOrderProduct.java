package com.keyrus.keyrusStore.utility;

import com.keyrus.keyrusStore.orderProduct.OrderProductDTO;
import com.keyrus.keyrusStore.orderProduct.OrderProductModel;
import org.springframework.stereotype.Component;

@Component
public class MapOrderProduct implements MapEntity<OrderProductModel,OrderProductDTO> {

    @Override
    public OrderProductDTO mapToDTO(OrderProductModel orderProductModel) {

        OrderProductDTO orderProductDTO = new OrderProductDTO();
        orderProductDTO.setProductModel(orderProductModel.getProduct());
        orderProductDTO.setQuantity(orderProductModel.getQuantity());
        orderProductDTO.setId(orderProductModel.getId());

        return orderProductDTO;
    }

    @Override
    public OrderProductModel mapToEntity(OrderProductDTO orderProductDTO) {

        OrderProductModel orderProductModel = new OrderProductModel();
        orderProductModel.setId(orderProductDTO.getId());
        orderProductModel.setQuantity(orderProductDTO.getQuantity());
        orderProductModel.setProduct(orderProductDTO.getProductModel());

        return orderProductModel;
    }
}
