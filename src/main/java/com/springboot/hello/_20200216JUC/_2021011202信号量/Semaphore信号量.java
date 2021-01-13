package com.springboot.hello._20200216JUC._2021011202信号量;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Semaphore信号量 {

    public static void main(String[] args) {
        /**
         * 信号量，什么是信号量
         *
         * 场景：多个任务抢夺有限资源，抢占执行
         *      指定同时操作每个任务的数量
         *      实现资源池
         */

        //5个可用资源
        final Semaphore semaphore = new Semaphore(5);

        //模拟10个用户抢占
        for (int i = 0; i < 10; i++) {
            new Thread(new SemaphoreRunnable(i,semaphore)).start();
        }
    }
}

class SemaphoreRunnable implements Runnable{

    //模拟随机线程等待，随机种子
    private static Random random = new Random(10);

    private int id;
    private Semaphore semaphore;

    public SemaphoreRunnable(int id,Semaphore semaphore) {
        this.id = id;
        this.semaphore = semaphore;
    }

    @SneakyThrows
    @Override
    public void run() {
        /**
         * 1 获取信号量许可
         * 2 随机等待，模拟拉屎时间
         * 3 释放信号量
         */
        semaphore.acquire();
        System.out.println(Thread.currentThread().getName());
        System.out.println("第"+id+"客户进来了");
        TimeUnit.SECONDS.sleep((int) (Math.random() * 10));
        semaphore.release();
    }
}