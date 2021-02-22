package com.springboot.hello._20200216JUC._2021022201LockSupport讲解._002锁关键字及Lock类自身的唤醒等待三角关系;

public class _01锁关键字正确的等待唤醒 {
    private static Object lockObject = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (lockObject){
                System.out.println(Thread.currentThread().getName()+"--in");
                try {
                    System.out.println(Thread.currentThread().getName()+"--等待中");
                    lockObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"--被唤醒了");
            }

        },"A").start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"--in");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockObject){
                try {
                    lockObject.notify();
                    System.out.println(Thread.currentThread().getName()+"--go to notify");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"B").start();
    }
}
