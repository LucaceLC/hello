package com.springboot.hello._2023060601JUC._2021010201原子变量;

public class ErrorApp {


    public static void main(String[] args) {

        ErrorRunnable errorRunnable = new ErrorRunnable();
        for (int i = 0; i < 10; i++) {
            new Thread(errorRunnable).start();
        }
    }
}


class ErrorRunnable implements Runnable{
    private int number = 0;
    @Override
    public void run() {
        try {
            //延迟放大效果
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(number++);
    }
}
