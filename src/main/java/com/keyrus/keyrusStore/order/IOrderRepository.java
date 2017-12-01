package com.keyrus.keyrusStore.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends CrudRepository<OrderModel,Long> {

    Iterable<OrderModel> findByCustomerModelId(Long id);

}
