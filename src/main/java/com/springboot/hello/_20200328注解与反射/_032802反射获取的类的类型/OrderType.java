package com.springboot.hello._20200328注解与反射._032802反射获取的类的类型;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderType {

    NORMAL(1,"normal");

    private int value;
    private String name;
}
