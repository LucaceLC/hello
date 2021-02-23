package com.springboot.hello._20200216JUC._2021022201LockSupport讲解._003Support用法于原理;

import java.util.concurrent.locks.LockSupport;

public class LockSupport正确的等待唤醒 {
    /**
     * LockSupport和每个使用它的线程都有一个许可关联，
     * LockSupport有个许可证permit，park阻塞线程需要消耗许可证，permit-1
     * unpark的时候，向指定线程颁发许可证，permit+1，但是许可证的上限是1，所以重复调用不会积累许可证，底层调用的是Unsafe方法
     *
     * 因为是许可证的+1-1，无论唤醒线程是否再等待线程之前执行，等待线程都会被正确唤醒
     *
     */
    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "--in");
            System.out.println(Thread.currentThread().getName() + "--等待中");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "--被唤醒了");
        }, "A");
        threadA.start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"--in");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(threadA);
            System.out.println(Thread.currentThread().getName()+"--go to notify");

        },"B").start();
    }
}
