package com.keyrus.keyrusStore.customer;

import javax.persistence.*;

@Entity(name = "k_user")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="k_user_name")
    private String customerName;
    private String description;


    private String password;

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }



    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getCustomerName() {

        return customerName;
    }

    public void setCustomerName(String customerName) {

        this.customerName = customerName;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }
}
