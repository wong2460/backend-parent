package com.wong.backend_test.quartz.service;

import com.wong.backend_test.quartz.dao.entity.Order;
import com.wong.backend_test.quartz.dao.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public void createOrder() {
        Random random = new Random();
        int count = random.nextInt(5);
        for (int i = 0; i <count; i++) {
            Order TOrder = new Order();
            TOrder.setAmount(BigDecimal.TEN);
            TOrder.setStatus(1);
            TOrder.setReceiveName("xxxx");
            TOrder.setReceiveAddress("XXXXX");
            TOrder.setReceiveMobile("13811112222");
            TOrder.setCreateTime(LocalDateTime.now());
            TOrder.setCreateUser("test");
            TOrder.setUpdateTime(LocalDateTime.now());
            TOrder.setUpdateUser("test");
            orderMapper.insert(TOrder);

        }
    }
}
