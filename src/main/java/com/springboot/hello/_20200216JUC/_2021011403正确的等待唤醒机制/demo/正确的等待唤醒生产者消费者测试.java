package com.springboot.hello._20200216JUC._2021011403正确的等待唤醒机制.demo;

import lombok.SneakyThrows;

public class 正确的等待唤醒生产者消费者测试 {

    //todo 应使用while循环判断wait条件
    public static void main(String[] args) {
        NoClerk clerk = new NoClerk();
        ProducerRunnable producerRunnable = new ProducerRunnable(clerk);
        ConsumerRunnable consumerRunnable = new ConsumerRunnable(clerk);

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

class NoClerk{
    //商品
    private int productNumber = 0;

    @SneakyThrows
    public synchronized void sale(){
        while (productNumber <= 0){
            System.out.println("货物已卖光");
            this.wait();
        }
            System.out.println(String.format("卖货: %s，产品数量: %d",Thread.currentThread().getName(),--productNumber));
            this.notifyAll();

    }
    @SneakyThrows
    public synchronized void get(){
        /**
         * 进货: 生产者A，产品数量: 1
         * 卖货: 消费者A，产品数量: 0
         * 进货: 生产者A，产品数量: 1
         * 货物已满 一直卡住
         *
         * 如果productNumber = 10; 不会卡住
         */
        while (productNumber>=10){
            System.out.println("货物已满");
            this.wait();
        }

        System.out.println(String.format("进货: %s，产品数量: %d",Thread.currentThread().getName(),++productNumber));
        this.notifyAll();
    }
}

class ConsumerRunnable implements Runnable{
    private NoClerk clerk;

    public ConsumerRunnable(NoClerk clerk) {
        this.clerk = clerk;
    }

    @SneakyThrows
    @Override
    public void run() {
        //模拟并发
        for (int i = 0; i < 20; i++) {
            Thread.sleep(500);
            //等待和唤醒
            //todo 下一次会一直停在这个等待，没有消费者对生产者进行唤醒了
            //todo 因为模拟了消费者运行更快，循环次数先完成
            clerk.sale();
        }
    }
}

class ProducerRunnable implements Runnable{
    private NoClerk clerk;

    public ProducerRunnable(NoClerk clerk) {
        this.clerk = clerk;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.get();
        }
    }
}