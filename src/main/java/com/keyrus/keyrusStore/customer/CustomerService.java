package com.keyrus.keyrusStore.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class CustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;
    /*
    @Autowired
    private PasswordEncoder passwordEncoder;
*/

    public CustomerModel createCustomer(CustomerModel customerModel){

        return iCustomerRepository.save(customerModel);
    }

    @PutMapping
    public CustomerModel updateCustomer(CustomerModel customerModel){

        return iCustomerRepository.save(customerModel);
    }

    public CustomerModel readCustomerById(Long customerId){

        return iCustomerRepository.findOne(customerId);
    }

    public CustomerModel readCustomerByName(String customerName){

        return iCustomerRepository.findByCustomerName(customerName);
    }

    public String deleteCustomer(CustomerModel customerModel){

        iCustomerRepository.delete(customerModel);
        return "Delete";
    }

    public  Iterable<CustomerModel> readAll(){

        return iCustomerRepository.findAll();
    }
}