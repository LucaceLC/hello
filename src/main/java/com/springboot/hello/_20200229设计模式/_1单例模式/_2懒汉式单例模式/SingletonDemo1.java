package com.springboot.hello._20200229设计模式._1单例模式._2懒汉式单例模式;

import java.util.Objects;

/**
 * 单例模式
 *  2懒汉式
 *    线程安全
 *    需要的时候才加载
 */
public class SingletonDemo1 {
    private static SingletonDemo1 instance;
    private SingletonDemo1(){}

    //synchronized 多线程环境下，需要使用synchronized保证线程安全
    public static synchronized SingletonDemo1 getInstance(){
        if(Objects.isNull(instance)){
            instance = new SingletonDemo1();
        }
        return instance;
    }
}
