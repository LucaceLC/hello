package com.springboot.hello._20190910Value注解;

public interface Test {
    static void fuc() {
        //java 1。8之后接口可有自己默认实现
        System.out.println("static fuc");
    }

    public static void main(String[] args) {
        Test.fuc();
    }
}
