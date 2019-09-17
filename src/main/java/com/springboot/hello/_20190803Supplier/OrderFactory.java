package com.springboot.hello._20190803Supplier;

import org.springframework.util.function.SupplierUtils;

import java.util.function.Supplier;

public class OrderFactory {

    public static Order newOrder(){
        Supplier<Order> orderSupplier = Order::new;
        return orderSupplier.get();
    }

    //使用SupplierUtils获取商户接口的值
    public static Order newOrderWithSupplierUtils(){
        return SupplierUtils.resolve(Order::new);
    }

    public static OrderReturn newOrderReturn(){
        Supplier<OrderReturn> orderSupplier = OrderReturn::new;
        return orderSupplier.get();
    }
}
