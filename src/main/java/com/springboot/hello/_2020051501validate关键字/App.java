package com.springboot.hello._2020051501validate关键字;

public class App {
    public static void main(String[] args) {
        /**
         * 多个线程的
         *
         * 线程1   主线程
         *
         * jvm会为每一个线程分配自己单独的线程
         * 线程中的写操作不是原子行的
         *  1把主存内的数据读取到线程内
         *  2对复制的数据进行赋值
         *  3重新把值写回到主存中
         *
         * 线程与线程之间的内存变量是不可见的，因为内存栅栏
         *
         * validate：防重排序，直接操作主存中的数据
         */
        PrintThread printThread = new PrintThread();
        Thread thread = new Thread(printThread);
        thread.start();

        /**
         * 分析：   main线程     printThread线程
         */
        while (true) {
            if (printThread.isFlag()) {
                System.out.println("hello world");
                break;
            }
        }
    }
}


class PrintThread implements Runnable {
    private boolean isFlag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        isFlag = true;
        System.out.println("isFlag:" + isFlag);
    }

    public boolean isFlag() {
        return isFlag;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }
}