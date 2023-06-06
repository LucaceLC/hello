package com.springboot.hello._2023060601JUC._2021011402消费生产者问题加入等待唤醒机制;

import lombok.SneakyThrows;

public class 错误的等待唤醒生产者消费者测试 {

    //todo if/else分支判断造成的虚假唤醒
    public static void main(String[] args) {
        NoClerk clerk = new NoClerk();
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

class NoClerk{
    //商品
    private int productNumber = 0;

    @SneakyThrows
    public synchronized void sale(){
        if(productNumber <= 0){
            System.out.println("货物已卖光");
            this.wait();
        }else {
            System.out.println(String.format("卖货: %s，产品数量: %d",Thread.currentThread().getName(),--productNumber));
            this.notifyAll();
        }
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
        if(productNumber>=10){
            System.out.println("货物已满");
            this.wait();
        }else {
            System.out.println(String.format("进货: %s，产品数量: %d",Thread.currentThread().getName(),++productNumber));
            this.notifyAll();
        }
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