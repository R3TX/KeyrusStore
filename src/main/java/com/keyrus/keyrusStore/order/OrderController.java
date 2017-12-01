package com.keyrus.keyrusStore.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/find")
    @ResponseBody
    public OrderDTO  find(@RequestParam("id") String id){

        return  orderService.readOrder(Long.valueOf(id));
    }

    @PostMapping("/create")
    @ResponseBody
    public OrderDTO create(@RequestBody OrderDTO orderDTO){

        return orderService.createOrder(orderDTO);
    }

    @GetMapping("/findByUser")
    @ResponseBody
    public Iterable<OrderDTO>  findByUser(@RequestParam("id") String id){

        return orderService.readByUserId(Long.valueOf(id));
    }

    @GetMapping("/all")
    @ResponseBody
    public Iterable<OrderDTO> all(){

       return orderService.readAll();
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam("id") String id){


        return orderService.deleteOrder(Long.valueOf(id));
    }

    @PutMapping("/update")
    @ResponseBody
    public OrderDTO  update(@RequestBody OrderDTO orderDTO){
        return orderService.updateOrderDynamic(orderDTO);
    }


    @PutMapping("/update2")
    @ResponseBody
    public OrderDTO  update2(@RequestBody OrderDTO orderDTO){

        return orderService.updateQuantity(orderDTO);
    }

}
