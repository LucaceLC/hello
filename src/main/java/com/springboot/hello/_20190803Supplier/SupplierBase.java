package com.springboot.hello._20190803Supplier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.function.Supplier;

public class SupplierBase {

    @Test
    public void defaultUserSupplier(){
        Supplier<Order> orderSupplier = Order::new;

        //工厂方法
        Order dbOrder = orderSupplier.get();
        Order order = orderSupplier.get();


        Assertions.assertNotEquals(dbOrder,order);
    }

    @Test
    public void userSupplierFactory(){
        Order dbOrder = OrderFactory.newOrder();
        Order order = OrderFactory.newOrder();
        Assertions.assertNotEquals(dbOrder,order);
    }
}


