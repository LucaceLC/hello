package com.springboot.hello._20191105MybatisPlus联系._1105CURD基础.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.hello._20191105MybatisPlus联系._1105CURD基础.entity.Order;


public interface OrderService extends IService<Order> {

    void selectById(Long id);
}
