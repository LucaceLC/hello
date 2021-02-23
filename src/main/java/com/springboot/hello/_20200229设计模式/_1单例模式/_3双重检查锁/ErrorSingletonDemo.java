package com.springboot.hello._20200229设计模式._1单例模式._3双重检查锁;

import java.util.Objects;

/**
 * 单例模式
 * 2懒汉式
 * 线程安全
 * 需要的时候才加载
 */
public class ErrorSingletonDemo {
    private static  ErrorSingletonDemo instance;

    private ErrorSingletonDemo() {
    }

    // 并且其中一个线程首先通过了第二次检查并实例化了对象，那么剩余通过了第一次检查的线程就不会再去实例化对象
    public static ErrorSingletonDemo getInstance() {
        //可能多个线程同时通过了第一次检查
        if (Objects.isNull(instance)) {
            synchronized (ErrorSingletonDemo.class) {
                if (Objects.isNull(instance))
                        instance = new ErrorSingletonDemo();

            }
        }
        return instance;
    }
}
