package com.springboot.hello._2020110203super关键字验证;

public class SuperTest {

    public static void main(String[] args) {
        /**
         * 问题一，super关键字有什么作用
         * 问题二，子类在初始化的过程中，为什么要调用父类的构造方法，其目的是什么
         */
        new SonClass();
    }
}

class SuperClass{
    public SuperClass(){
        System.out.println("super init");
    }
}

class SonClass extends SuperClass{
    public SonClass(){
        System.out.println("son init");
    }
}
