package com.springboot.hello._20190917Ioc._072021022601AOP._022021022701cglab代理实现._012021022601jdk的动态代理实现;

public class MyAspect {

    public void before(){
        System.out.println("开启事物");
    }
    public void after(){
        System.out.println("提交事物");

    }
}
