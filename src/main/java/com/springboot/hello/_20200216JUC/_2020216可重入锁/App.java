package com.springboot.hello._20200216JUC._2020216可重入锁;


import org.junit.jupiter.api.Test;

public class App {

    /**
     * Lock锁，比锁关键字更灵活，是一种轻量级的锁
     *
     * 3个售票员，卖 30张票
     *
     * 线程 操作 资源
     */

    @Test
    public void testReentertLockFunction(){

        Ticket ticket = new Ticket();
        for (int i = 0; i < 3; i++) {
            new Thread(ticket::sale,"线程"+i).start();
        }

    }
}

class Ticket{
    private int initNumber = 30;

    /**
     * 方法一 方法上加synchronized
     *      public synchronized void sale()
     *          锁的粒度大
     * 方法二  代码块上加锁 锁粒度更小
     *       public void sale(){
     *         synchronized(this){
     *             System.out.println(Thread.currentThread().getName() +"卖第" + initNumber-- +",还剩"+initNumber);
     *         }
     *     }
     */
    public void sale(){
        synchronized(this){
            if(initNumber>0)
                System.out.println(Thread.currentThread().getName() +"卖第" + initNumber-- +",还剩"+initNumber);
        }
    }


}