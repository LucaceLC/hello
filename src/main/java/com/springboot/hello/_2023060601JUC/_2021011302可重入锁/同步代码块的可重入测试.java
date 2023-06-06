package com.springboot.hello._2023060601JUC._2021011302可重入锁;

public class 同步代码块的可重入测试 {
    private static Object lockObject = new Object();

    public static void m1(){
       synchronized (lockObject){
           System.out.println(Thread.currentThread().getName() + "==外");
           synchronized (lockObject){
               System.out.println(Thread.currentThread().getName() + "==中");
               synchronized (lockObject){
                   System.out.println(Thread.currentThread().getName() + "==内");
               }
           }
       }
    }

    public static void main(String[] args) {
        m1();
    }
}
