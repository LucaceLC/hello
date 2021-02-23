package com.springboot.hello._20200216JUC._2021011302可重入锁;

import java.util.concurrent.locks.ReentrantLock;

public class 可重入锁测试 {
    public static void main(String[] args) {
        TicketRunnable ticketRunnable = new TicketRunnable();
        for (int i = 0; i < 50; i++) {
            new Thread(ticketRunnable,i+"").start();
        }

    }
}

/**
 * 加锁的方式：
 *    同步代码块
 *    同步方法
 *    显示锁
 */
class TicketRunnable implements Runnable{
    private int ticketNumber = 10000;
    private final ReentrantLock lock =  new ReentrantLock();

    @Override
    public void run() {

        if (ticketNumber > 0) {
            //上锁
            lock.lock();
            try {
                    //放大线程安全问题，设置延时
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    --ticketNumber;
                    //打印输出
                    System.out.println(Thread.currentThread().getName()
                            + "开始售票,还剩" +  ticketNumber + "张");
            } finally {
                lock.unlock();
            }
        }
    }
}


