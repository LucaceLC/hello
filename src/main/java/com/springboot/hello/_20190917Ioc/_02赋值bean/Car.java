package com.springboot.hello._20190917Ioc._02赋值bean;

import lombok.Data;

@Data
public class Car {
    private String name;

    public Car(){
        System.out.println("构造  ...");
    }

    public void setName(String name) {
        System.out.println("setting color  ...");
        this.name = name;
    }
}
