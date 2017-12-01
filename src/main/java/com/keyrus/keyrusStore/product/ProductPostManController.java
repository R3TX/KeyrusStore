package com.keyrus.keyrusStore.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductPostManController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ProductModel create(@RequestBody ProductModel productModel){

        return productService.createProduct(productModel);
    }

    @GetMapping("/all")
    public Iterable<ProductModel> all(){

        return productService.readAll();
    }

    @GetMapping("/find")
    public ProductModel  find(@RequestParam("id") String id){

        return  productService.readProduct(Long.valueOf(id));
    }

    @GetMapping("/findByName")
    public ProductModel  findByName(@RequestParam("name") String name){

        return  productService.readProductByName(name);
    }

    @PutMapping("/update")
    public ProductModel update(@RequestBody ProductModel productModel){

        return productService.updateProduct(productModel);
    }
    @DeleteMapping("/delete")
    public String delete(@RequestBody ProductModel productModel){

        return productService.deleteProduct(productModel);
    }

}
