package com.springboot.hello._20200229设计模式._1单例模式._3双重检查锁;

import java.util.Objects;

/**
 * 单例模式
 * 2懒汉式
 * 线程安全
 * 需要的时候才加载
 */
public class BetterSingletonDemo {
    //volatile 禁止重排序
    private static volatile BetterSingletonDemo instance;

    private BetterSingletonDemo() {
    }

    // 并且其中一个线程首先通过了第二次检查并实例化了对象，那么剩余通过了第一次检查的线程就不会再去实例化对象
    public static BetterSingletonDemo getInstance() {
        //局部变量提高性能
        BetterSingletonDemo localSingleton = instance;
        //可能多个线程同时通过了第一次检查
        if (Objects.isNull(localSingleton)) {
            synchronized (BetterSingletonDemo.class) {
                localSingleton = instance;
                if (Objects.isNull(localSingleton)) {
                    localSingleton = new BetterSingletonDemo();
                    instance = localSingleton;

                }
            }
        }
        return instance;
    }
}
