package com.springboot.hello._2023060601Java基础._2023061601String._2023061601String不可变;

public class App {
    /**
     *【String和StringBuffer，StringBuilder的区别】
     * 可变性
     *  三个类都被final，都不可被继承
     *  String的底层是一个被final修饰的byte数组，所以不可变，每次操作String都是重新实例一个String对象
     *  StringBuilder、StringBuffer是可变的，底层也是数组，不过可变，如果实际使用字符串拼接很长，可以初始化给个合适容量
     *  如果字符大小超过容量，会进行扩容，Arrays.copy数组copy的过程
     * 线程安全
     *  String和Buffer都是线程安全的，String因为不可变性，buffer是因为synzied关键字，每个方法都加锁了
     *  Builder是线程不安全的
     * 性能
     *  Builder性能相对较快
     *
     *  【为什么String不可变】
     *  因为String的底层是一个被final修饰的byte数组，对象创建后不可变更
     */

}
