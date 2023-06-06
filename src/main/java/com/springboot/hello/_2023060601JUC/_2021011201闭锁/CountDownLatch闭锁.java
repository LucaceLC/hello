package com.springboot.hello._2023060601JUC._2021011201闭锁;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch闭锁 {
    /**
     * 场景：5个线程叠加计数，计算总耗时
     *
     *
     * 运行机制：闭锁包含一个计数器，计数器为正数，表示处理时间的数量，每次countDown递减计数器，表示一个时间执行完成
     *  await方法，直到计数器为0，闭锁结束，表示所有时间执行完成
     */
    public static void main(String[] args) {
        /**
         * 闭锁，多个线程执行任务，让线程等待其他线程执行完毕，再继续执行
         * 1 定义一个常量闭锁，设置闭锁等待次数
         * 2 其他线程执行完毕，闭锁countDown一次，-1，并发加锁
         * 3 主线程上，线程等待
         */
        final CountDownLatch downLatch = new CountDownLatch(5);
        CountDownLatchRunnable runnable = new CountDownLatchRunnable(downLatch);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 5; i++) {
            new Thread(runnable).start();
        }

        //闭锁一致等待
        try {
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("总耗时(ms) ："+ (System.currentTimeMillis() - startTime));

    }
}

/**
 * 问题1 什么是闭锁，一种同步工具类，闭锁到达结束状态前，一直等待，直到闭锁结束
 * 问题2 什么场景使用，确保所有任务执行完毕，才进行一步
 */
class CountDownLatchRunnable implements Runnable{

    private CountDownLatch countDownLatch;

    public CountDownLatchRunnable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        int sum = 0;
        synchronized (this){
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                sum+=i;
            }
            System.out.println(sum);
            countDownLatch.countDown();
        }
    }
}
