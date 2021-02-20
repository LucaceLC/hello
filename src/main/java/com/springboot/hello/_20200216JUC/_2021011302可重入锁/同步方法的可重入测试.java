package com.springboot.hello._20200216JUC._2021011302可重入锁;

public class 同步方法的可重入测试 {
    private synchronized void m1(){
        System.out.printf(Thread.currentThread().getName() + "==外");
        m2();
    }

    private synchronized void m2() {
        System.out.printf(Thread.currentThread().getName() + "==中");
        m3();
    }

    private synchronized void m3() {
        System.out.printf(Thread.currentThread().getName() + "==内");
    }

    public static void main(String[] args) {
        new 同步方法的可重入测试().m1();
    }
}
