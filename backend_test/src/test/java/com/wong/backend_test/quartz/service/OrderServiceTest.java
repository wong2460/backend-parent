package com.wong.backend_test.quartz.service;


import com.wong.backend_test.BackendTestApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
* OrderService Tester. 
* 
* @author <Authors name> 
* @since <pre>06/05/2020</pre> 
* @version 1.0 
*/ 
public class OrderServiceTest extends BackendTestApplicationTests {

    
        /** 
    * 
    * Method: createOrder() 
    *
    */
    @Autowired
    private OrderService orderService;
    @Test
    public void testCreateOrder() {
        orderService.createOrder();

    }


    
        
}
