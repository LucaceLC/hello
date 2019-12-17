package com.springboot.hello._20191217反射机制._20191217自定义注解;

public class App {

    public static void main(String[] args) {
        retentionWithSource();
    }

    @MyAnnotation
    public static void retentionWithSource(){};
}
