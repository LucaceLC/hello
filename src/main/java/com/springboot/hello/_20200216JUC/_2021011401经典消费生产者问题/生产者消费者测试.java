package com.springboot.hello._20200216JUC._2021011401经典消费生产者问题;

import lombok.SneakyThrows;

public class 生产者消费者测试 {

    /**
     * 模拟生产问题，当消费速度 》》生产速度
     *
     * 会造成一致等待，不会中止线程
     * @param args
     */
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        ProducerRunnable producerRunnable = new ProducerRunnable(clerk);
        ConsumerRunnable consumerRunnable = new ConsumerRunnable(clerk);

        new Thread(producerRunnable,"生产者A").start();

        new Thread(consumerRunnable,"消费者A").start();
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

class Clerk{
    //商品
    private int productNumber = 0;

    //对象锁
    @SneakyThrows
    public synchronized void sale(){
        if(productNumber <= 0){
            System.out.println("货物已卖光");
        }else {
            System.out.println(String.format("卖货: %s，产品数量: %d",Thread.currentThread().getName(),--productNumber));
        }
    }
    @SneakyThrows
    public synchronized void get(){
        if(productNumber>=10){
            System.out.println("货物已满");
        }else {
            System.out.println(String.format("进货: %s，产品数量: %d",Thread.currentThread().getName(),++productNumber));
        }
    }
}

class ConsumerRunnable implements Runnable{
    private Clerk clerk;

    public ConsumerRunnable(Clerk clerk) {
        this.clerk = clerk;
    }

    @SneakyThrows
    @Override
    public void run() {
        //模拟并发
        for (int i = 0; i < 20; i++) {

            clerk.sale();
        }
    }
}

class ProducerRunnable implements Runnable{
    private Clerk clerk;

    public ProducerRunnable(Clerk clerk) {
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