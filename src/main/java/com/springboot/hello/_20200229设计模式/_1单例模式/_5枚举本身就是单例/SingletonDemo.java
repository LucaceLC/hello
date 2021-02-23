package com.springboot.hello._20200229设计模式._1单例模式._5枚举本身就是单例;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum SingletonDemo {
    INSTANCE(-1L,"默认");
    private Long id;
    private String name;

    public static void main(String[] args) {
        SingletonDemo instance = SingletonDemo.INSTANCE;
        System.out.println(instance);
    }
}
