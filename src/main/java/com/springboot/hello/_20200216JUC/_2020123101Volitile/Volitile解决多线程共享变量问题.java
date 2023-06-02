package com.springboot.hello._20200216JUC._2020123101Volitile;

import lombok.Data;
import org.junit.jupiter.api.Test;

public class Volitile解决多线程共享变量问题 {

    @Test
    public void failThread() {
        VolatileThreadDemo volitileThreadDemo = new VolatileThreadDemo();
        new Thread(volitileThreadDemo).start();

        while (true){
            if(volitileThreadDemo.getFlag()){
                System.out.println("flag is change, flag is " +volitileThreadDemo.getFlag());
                break;
            }
        }
    }
}


@Data
class VolatileThreadDemo implements Runnable {
    /**
     * volatile关键字
     * 保证线程之间对共享变量的操作的可见性，禁止线程对修饰的共享变量进行缓存
     *
     * 直接修改主内存，每次使用前立即从主存刷新
     *
     * 并且禁止重排序，是一种轻量级的同步策略
     *
     * 不具备加锁的互斥性
     * 也不具备原子性，仍然存在线程安全问题
     *
     * volatile只保证了可见性，不能保证线程安全
     *
     */
    private volatile Boolean flag = false;

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
