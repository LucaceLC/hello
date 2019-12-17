package com.springboot.hello._20191105MybatisPlus联系._1105CURD基础.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.hello._20191105MybatisPlus联系.OrderMapper;
import com.springboot.hello._20191105MybatisPlus联系._1105CURD基础.entity.Order;
import lombok.NonNull;

//@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Override
    public void selectById(@NonNull Long id) {

    }
}
