package com.springboot.hello._2023060601JUC._2021020801什么是可重入锁.自己实现不可重入锁;

public class 自己实现不可重入锁 {
    private MyLock lock = new MyLock();
    public void noLockMethod1(){
        lock.lock();
        noLockMethod2();
        System.out.println("执行方法1");
        lock.unLock();
    }
    public void noLockMethod2(){
        lock.lock();
        System.out.println("执行方法2");
        lock.unLock();
    }
    /**
     * 什么是可重入锁：
     * 如果一个线程去获取已经持有的锁时，可以立即获取，
     * 并且锁计数器+1，当执行完同步代码快时，锁计数器--1
     * 当锁计数器==0，锁立即释放
     */


    public static void main(String[] args) {
        自己实现不可重入锁 demo = new 自己实现不可重入锁();
        //死循环，获取锁后没有释放
        demo.noLockMethod1();
    }
}

class MyLock{
    /**
     * 自己实现锁方法
     */
    private boolean isLock = false;
    public synchronized void lock(){
        while (isLock){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //上锁
        System.out.println("加锁");
        isLock = true;
    }

    public  synchronized void unLock(){
        this.notify();
        System.out.println("释放锁");
        isLock = false;
    }
}
