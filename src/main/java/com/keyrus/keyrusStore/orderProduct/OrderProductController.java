package com.keyrus.keyrusStore.orderProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orderProduct")
public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;

    @PostMapping("/create")
    @ResponseBody
    public OrderProductModel create(@RequestBody OrderProductModel orderProductModel){

        return orderProductService.createOrderProduct(orderProductModel);
    }

    @GetMapping("/all")
    @ResponseBody
    public Iterable<OrderProductModel> all(){

        return orderProductService.readAll();
    }

    @GetMapping("/find")
    @ResponseBody
    public OrderProductModel  find(@RequestParam("id") String id){

        return  orderProductService.readById(Long.valueOf(id));
    }
    @GetMapping("/findByOrder")
    @ResponseBody
    public Iterable<OrderProductModel>  findByOrder(@RequestParam("id") String id){

        return  orderProductService.readByOrderId(Long.valueOf(id));
    }
    @GetMapping("/findByProduct")
    @ResponseBody
    public Iterable<OrderProductModel>  findByProduct(@RequestParam("id") String id){

        return  orderProductService.readByProductId(Long.valueOf(id));
    }

    @PutMapping("/update")
    @ResponseBody
    public OrderProductModel update(@RequestBody OrderProductModel orderProductModel){

        return orderProductService.updateOrderProduct(orderProductModel);
    }
    @DeleteMapping("/delete")
    @ResponseBody
    public String delete(@RequestBody OrderProductModel orderProductModel){

        return orderProductService.deleteOrderProduct(orderProductModel);
    }
}
