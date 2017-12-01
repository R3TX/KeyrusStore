package com.keyrus.keyrusStore.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 *
 */
@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    @ResponseBody
    public CustomerModel create(@RequestBody CustomerModel customerModel){

        return customerService.createCustomer(customerModel);
    }

    @GetMapping("/all")
    @ResponseBody
    public Iterable<CustomerModel> all(){

        return customerService.readAll();
    }

    @GetMapping("/find")
    @ResponseBody
    public CustomerModel  find(@RequestParam("id") String id){

        return  customerService.readCustomerById(Long.valueOf(id));
    }

    @GetMapping("/findByName")
    @ResponseBody
    public CustomerModel  findByName(@RequestParam("name") String name){

        return  customerService.readCustomerByName(name);
    }

    @PutMapping("/update")
    @ResponseBody
    public CustomerModel update(@RequestBody CustomerModel customerModel){

        return customerService.updateCustomer(customerModel);
    }
    @DeleteMapping("/delete")
    @ResponseBody
    public String delete(@RequestBody CustomerModel customerModel){

        return customerService.deleteCustomer(customerModel);
    }


}
