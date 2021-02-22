package com.springboot.hello._20200216JUC._2021022201LockSupport讲解._002锁关键字及Lock类自身的唤醒等待三角关系;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _06Lock唤醒先于等待_造成线程一直阻塞 {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    /**
     * Lock的Condition的等待唤醒机制，condition的await和signal不能脱离锁类，否则也会抛出非法监视器状态异常
     */
    public static void main(String[] args) {
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"--in");
                try {
                    System.out.println(Thread.currentThread().getName()+"--等待中");
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"--被唤醒了");
            }finally {
                lock.unlock();
            }
        },"A").start();

        new Thread(()->{
            try {
                lock.lock();
                try {
                    condition.signal();
                    System.out.println(Thread.currentThread().getName()+"--go to notify");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }finally {
                lock.unlock();
            }
        },"B").start();
    }
}
