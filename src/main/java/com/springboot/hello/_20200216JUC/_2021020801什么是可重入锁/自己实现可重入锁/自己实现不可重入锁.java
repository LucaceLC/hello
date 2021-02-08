package com.springboot.hello._20200216JUC._2021020801什么是可重入锁.自己实现可重入锁;

public class 自己实现不可重入锁 {
    private MyReLock reLock = new MyReLock();

    public void reLockMethod1(){
        reLock.lock();
        System.out.println("reLockMethod1:lock:"+reLock.getHolderCount());
        System.out.println("执行方法1");
        reLock.unLock();
        System.out.println("reLockMethod1:unLock"+reLock.getHolderCount());

    }
    public void reLockMethod2(){
        reLock.lock();
        System.out.println("reLockMethod2:lock:"+reLock.getHolderCount());
        System.out.println("执行方法2");
        reLockMethod1();
        reLock.unLock();
        System.out.println("reLockMethod2:unlock:"+reLock.getHolderCount());
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
        demo.reLockMethod2();
    }
}

class MyReLock{
    /**
     * 自己实现锁方法
     */
    private boolean isLock = false;
    private int holderCount = 0;
    private Thread localThread = null;

    public int getHolderCount() {
        return holderCount;
    }

    public synchronized void lock(){
        Thread currentThread = Thread.currentThread();

        //如果锁上了，就等待
        while (isLock && currentThread != localThread){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //上锁
        System.out.println("加锁");
        isLock = true;
        holderCount ++;
        System.out.println("锁计数器+1");
        localThread = currentThread;
    }

    //todo 一定要有synchronized
    public synchronized void unLock(){
        /**
         * 可重入锁的释放逻辑
         * 当前线程等于自身时，锁计数器-1，当锁的计数器==0，锁才完全释放
         */
        if(Thread.currentThread() == localThread){

            holderCount--;
            System.out.println("锁计数器-1");
            if(holderCount == 0){
                this.notify();
                System.out.println("释放锁");
                isLock = false;
                localThread = null;
            }
        }
    }
}