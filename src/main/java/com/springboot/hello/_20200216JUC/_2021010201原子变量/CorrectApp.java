package com.springboot.hello._20200216JUC._2021010201原子变量;

import java.util.concurrent.atomic.AtomicInteger;

public class CorrectApp {

    public static void main(String[] args) {

        AtomicRunnable successRunnable = new AtomicRunnable();
        for (int i = 0; i < 10; i++) {
            new Thread(successRunnable).start();
        }
    }
}


class AtomicRunnable implements Runnable{
    private AtomicInteger number = new AtomicInteger();
    @Override
    public void run() {
        try {
            //延迟放大效果
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(number.getAndIncrement());
    }
}
