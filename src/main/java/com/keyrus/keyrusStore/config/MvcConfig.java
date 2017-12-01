/*


package com.keyrus.keyrusStore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");



        //registry.addViewController("/allOrders").setViewName("home");



        registry.addViewController("/product/pIndex").setViewName("product/pIndex");
        registry.addViewController("/order/oIndex").setViewName("order/oIndex");
        registry.addViewController("/customer/cIndex").setViewName("customer/cIndex");



//Urls del producto
        registry.addRedirectViewController("/productDetail","/product/productDetail").setKeepQueryParams(true);
        registry.addRedirectViewController("/modifyProduct","/product/modifyProduct").setKeepQueryParams(true);
        registry.addRedirectViewController("/newProduct","/product/newProduct").setKeepQueryParams(true);
        registry.addRedirectViewController("/productAll","/product/all").setKeepQueryParams(true);;

        //Urls de order
        registry.addRedirectViewController("/orderDetail","/order/orderDetail").setKeepQueryParams(true);
        registry.addRedirectViewController("/modifyOrder","/order/modifyOrder").setKeepQueryParams(true);
        registry.addRedirectViewController("/newOrder","/order/newOrder").setKeepQueryParams(true);
        registry.addRedirectViewController("/orderAll","/order/all").setKeepQueryParams(true);

        //Urls de customer
        registry.addRedirectViewController("/customerDetail","/customer/customerDetail").setKeepQueryParams(true);
        registry.addRedirectViewController("/modifyCustomer","/customer/modifyCustomer").setKeepQueryParams(true);
        registry.addRedirectViewController("/newCustomer","/customer/newCustomer").setKeepQueryParams(true);
        registry.addRedirectViewController("/customerAll","/customer/all").setKeepQueryParams(true);



    }


    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");
        return resolver;
    }


}

*/