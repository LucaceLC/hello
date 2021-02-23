package com.springboot.hello._20200229设计模式._1单例模式._3双重检查锁;

import java.util.Objects;

/**
 * 单例模式
 * 2懒汉式
 * 线程安全
 * 需要的时候才加载
 */
public class SingletonDemo {
    //volatile 禁止重排序
    private static volatile SingletonDemo instance;

    private SingletonDemo() {
    }

    // 并且其中一个线程首先通过了第二次检查并实例化了对象，那么剩余通过了第一次检查的线程就不会再去实例化对象
    public static SingletonDemo getInstance() {
        /**
         * 多个线程同时通过了第一次检查，A,B两个线程进来，都判断为null
         * A线程获取到锁对象，进入进行初始化，创建对象，创建完成，释放锁资源
         * B线程之前一直在等待，然后获取到锁，进入，判断instance对象不为空，跳出
         * 保证了多线程下的单例模式，volatile禁止立刻重排序
         */
        if (Objects.isNull(instance)) {
            synchronized (SingletonDemo.class) {
                if (Objects.isNull(instance))
                        instance = new SingletonDemo();

            }
        }
        return instance;
    }

}
