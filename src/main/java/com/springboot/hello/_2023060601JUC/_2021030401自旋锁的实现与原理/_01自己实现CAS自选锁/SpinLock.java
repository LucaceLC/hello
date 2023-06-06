package com.springboot.hello._2023060601JUC._2021030401自旋锁的实现与原理._01自己实现CAS自选锁;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
    AtomicReference<Thread> reference = new AtomicReference<>();
    public void lock(){
        Thread currentThread = Thread.currentThread();
        /**
         * 多个线程共同持有SpinLock，
         * 如果当前线程是null，cas中的线程预期也是null，那么把当前线程设置给reference这个变量
         * 表示当前线程获取到锁了，如果没有设置成功，表示有其他线程对SpinLock该锁占用了
         * 那么一直等待，直到获取锁
         *
         * CAS，直到比较替换完成，表示当前线程获取到锁，跳出循环
         */
        boolean isGetLock = reference.compareAndSet(null, currentThread);
        while (!isGetLock){
            //no thing
        }
    }

    public void unLock(){
        Thread currentThread = Thread.currentThread();
        if(reference.get() != currentThread){
            throw new IllegalArgumentException("未持有锁，不能释放锁");
        }
        reference.set(null);
    }
}
