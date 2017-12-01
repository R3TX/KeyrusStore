package com.keyrus.keyrusStore.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

@Service
public class ProductService {

    @Autowired
    private IProductRepository iProductRepository;

    public ProductModel createProduct(ProductModel productModel){

        return iProductRepository.save(productModel);
    }

    @PutMapping
    public ProductModel updateProduct(ProductModel productModel){

        return iProductRepository.save(productModel);
    }

    public ProductModel readProduct(Long productId){

       return iProductRepository.findOne(productId);
    }

    public String deleteProduct(ProductModel productModel){

        iProductRepository.delete(productModel);
        return "Deleted";
    }

    public ProductModel readProductByName(String productName){

        return iProductRepository.findByProductName(productName);
    }

    public  Iterable<ProductModel> readAll(){

        return iProductRepository.findAll();
    }
}
