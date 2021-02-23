package com.springboot.hello._20200229设计模式._1单例模式._4内部类实现单例;

/**
 * 单例模式
 * 2懒汉式
 * 线程安全
 * 需要的时候才加载
 */
public class SingletonDemo {

    private SingletonDemo(){}

    //内部类在加载时，也是在第一次使用时才会被初始化
    private static class Singleton{
        private static SingletonDemo INSTANCE = new SingletonDemo();
    }

    public SingletonDemo getInstance(){
        return Singleton.INSTANCE;
    }
}
