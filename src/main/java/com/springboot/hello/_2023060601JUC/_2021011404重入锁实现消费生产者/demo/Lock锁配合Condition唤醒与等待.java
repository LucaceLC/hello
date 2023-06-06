package com.springboot.hello._2023060601JUC._2021011404重入锁实现消费生产者.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock锁配合Condition唤醒与等待 {

    //todo 应使用while循环判断wait条件
    public static void main(String[] args) {
        NoClerk2 clerk = new NoClerk2();
        ProducerRunnable2 producerRunnable = new ProducerRunnable2(clerk);
        ConsumerRunnable2 consumerRunnable = new ConsumerRunnable2(clerk);

        new Thread(producerRunnable,"生产者A").start();
        new Thread(producerRunnable,"生产者B").start();
        new Thread(producerRunnable,"生产者C").start();
        new Thread(consumerRunnable,"消费者A").start();
        new Thread(consumerRunnable,"消费者B").start();
        new Thread(consumerRunnable,"消费者C").start();

    }

}


/**
 * 生产者消费者模式
 * 生产者任务
 * 消费者任务
 *
 * 店员主体，组织消费与生产
 *
 * 利用等待唤醒机制
 * */

class NoClerk2 {
    //商品
    private int productNumber = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void sale(){
        lock.lock();
        try {
            while (productNumber <= 0){
                System.out.println("货物已卖光");
                try {

                    //todo 非同步代码代码块如果使用 this.await()，this.notify this.notifyAll等
                    /**
                     * java.lang.IllegalMonitorStateException: current thread not owner
                     * 线程操作的wait()、notify()、notifyAll()方法只能在同步控制方法或同步控制块内调用。
                     * wait()、notify()、notifyAll()法只应由作为此对象监视器的所有者的线程来调用
                     * Clerk的所有者是主线程
                     * 如果在非同步控制方法或控制块里调用，程序能通过编译，但运行的时候，将得到 IllegalMonitorStateException 异常，并伴随着一些含糊信息，比如 ‘当前线程不是拥有者’。其实异常的含义是 调用wait()、notify()、notifyAll()的任务在调用这些方法前必须 ‘拥有’（获取）对象的锁
                     */
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(String.format("卖货: %s，产品数量: %d",Thread.currentThread().getName(),--productNumber));
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void get(){
        /**
         * 进货: 生产者A，产品数量: 1
         * 卖货: 消费者A，产品数量: 0
         * 进货: 生产者A，产品数量: 1
         * 货物已满 一直卡住
         *
         * 如果productNumber = 10; 不会卡住
         */
        lock.lock();
        try {
            while (productNumber>=10){
                System.out.println("货物已满");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(String.format("进货: %s，产品数量: %d",Thread.currentThread().getName(),++productNumber));
            condition.signalAll();

        }finally {
            lock.unlock();
        }

    }
}

class ConsumerRunnable2 implements Runnable{
    private NoClerk2 clerk;

    public ConsumerRunnable2(NoClerk2 clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        //模拟并发
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //等待和唤醒
            //todo 下一次会一直停在这个等待，没有消费者对生产者进行唤醒了
            //todo 因为模拟了消费者运行更快，循环次数先完成
            clerk.sale();
        }
    }
}

class ProducerRunnable2 implements Runnable{
    private NoClerk2 clerk;

    public ProducerRunnable2(NoClerk2 clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.get();
        }
    }
}