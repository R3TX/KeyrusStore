package com.keyrus.keyrusStore.orderProduct;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderProductRepository extends CrudRepository<OrderProductModel,Long> {

    Iterable<OrderProductModel> findByOrderId(Long id);
    Iterable<OrderProductModel> findByProductId(Long id);

}
