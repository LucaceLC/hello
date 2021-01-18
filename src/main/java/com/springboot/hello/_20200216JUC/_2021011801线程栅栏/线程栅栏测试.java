package com.springboot.hello._20200216JUC._2021011801线程栅栏;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class 线程栅栏测试 {

    /**
     * CyclicBarrier c克里barrier
     *
     * 线程栅栏，控制多线程任务同时执行的工具，栅栏计数未到0时，所有线程一直等待
     *
     */
    public static void main(String[] args) {
        /**
         * 创建线程栅栏，同时设置栅栏计数
         * 创建线程任务
         * 将栅栏传入线程任务
         * 每次等待一次，计数-1
         *
         * 创建多线程，传入任务，执行
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        CyclicBarrierRunnable runnable = new CyclicBarrierRunnable(cyclicBarrier);
        for (int i = 0; i < 10; i++) {
            new Thread(runnable,String.format("线程名-%s",i)).start();
        }

    }

}

class CyclicBarrierRunnable implements Runnable{
    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierRunnable(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        //线程随机等待
        try {
            Thread.sleep(new Random().nextInt(5000));
            System.out.println(String.format("%s准备完毕,开始等待其他线程准备",Thread.currentThread().getName()));
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("出发!");
    }
}

