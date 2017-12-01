package com.keyrus.keyrusStore.customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends CrudRepository<CustomerModel,Long> {

    CustomerModel findByCustomerName(String name);
}
