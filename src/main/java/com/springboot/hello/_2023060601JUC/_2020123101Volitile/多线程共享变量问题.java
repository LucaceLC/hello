package com.springboot.hello._2023060601JUC._2020123101Volitile;

import lombok.Data;
import org.junit.jupiter.api.Test;

public class 多线程共享变量问题 {
    /**
     * 多线程可见性问题
     * 为什么有这个问题
     *  多个线程，每个线程都有自己独立的寄存器缓存，用以提高效率
     *  有共享变量
     */
    @Test
    public void failThread() {
        ErrorThreadDemo errorThreadDemo = new ErrorThreadDemo();
        new Thread(errorThreadDemo).start();
        /**
         * 问题，多线程情况
         *      有共享变量
         *      和多线程读取共享变量到自己的线程缓存的顺序有关
         *      在error线程的flag=true，但是main线程读到的仍然是flag=false;
         *      main线程读取变量flag，是在自己的缓存区域读取的flag
         */
        while (true){
            if(errorThreadDemo.getFlag()){
                System.out.println("flag is change, flag is " +errorThreadDemo.getFlag());
                break;
            }
        }
    }

    @Test
    public void successThread() {
        ErrorThreadDemo errorThreadDemo = new ErrorThreadDemo();

        //线程sleep 1s
        new Thread(errorThreadDemo).start();

        //线程sleep 2s
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true){
            if(errorThreadDemo.getFlag()){
                System.out.println("flag is change, flag is " +errorThreadDemo.getFlag());
                break;
            }
        }
    }
}



@Data
class ErrorThreadDemo implements Runnable {
    private Boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag = "+this.getFlag());
    }
}
