package com.springboot.hello._2023060601JUC._2021022201LockSupport讲解._002锁关键字及Lock类自身的唤醒等待三角关系;

public class _02锁关键字会抛出异常的等待唤醒 {
    private static Object lockObject = new Object();

    /**
     * 非法的监视器异常，java.lang.IllegalMonitorStateException
     *
     * wait notify notifyAll不能脱离synchronized锁关键字单独使用
     * 否则会抛出非法监视器状态异常
     *
     */
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"--in");
            try {
                System.out.println(Thread.currentThread().getName()+"--等待中");
                lockObject.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--被唤醒了");

        },"A").start();

        new Thread(()->{
            try {
                lockObject.notify();
                System.out.println(Thread.currentThread().getName()+"--go to notify");
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}
