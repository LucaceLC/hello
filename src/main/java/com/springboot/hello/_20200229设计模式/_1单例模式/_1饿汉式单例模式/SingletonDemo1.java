package com.springboot.hello._20200229设计模式._1单例模式._1饿汉式单例模式;

/**
 * 单例模式
 *  饿汉式
 *      线程安全：为什么？ 饿汉式的单例模式下的成员是静态的，并且是从属于类的，
 *              虚拟机在加在类时，即可创建一个单例，只会加载一次类，所以是线程安全的
 *      效率高：需要使用时，直接调用方法返回单例
 *      缺点：不能实现延迟加载，不管此单例有没有被使用，都会创建出来，造成资源浪费
 */
public class SingletonDemo1 {
    /**
     * 三要素
     *  1该类的静态成员
     *  2构造器私有化
     *  3提供静态公有方法返回单例
     */
    private static SingletonDemo1 instance = new SingletonDemo1();
    private SingletonDemo1(){}

    public static SingletonDemo1 getInstance(){
        return instance;
    }
}
