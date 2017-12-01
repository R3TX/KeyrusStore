package com.keyrus.keyrusStore.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends CrudRepository<ProductModel,Long>{

    ProductModel findByProductName(String name);

}
