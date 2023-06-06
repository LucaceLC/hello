package com.springboot.hello._2023060601JUC._2021020701Condition实现线程的交替打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {

    public static void main(String[] args) {
        //todo key
        Show show = new Show();
        //一个对象，然后对对象进行加锁，
        // 一个对象的锁的争抢才是线程通信的基础
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                try {
                    show.printLnA();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            },"A").start();
            new Thread(()->{
                try {
                    show.printLnB();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            },"B").start();
            new Thread(()->{
                try {
                    show.printLnC();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            },"C").start();
        }
    }
}

/**
 * 交替打印的任务
 * 线程通信
 * 3个线程ABC交替打印，3个condition,交替唤醒
 * 线程加锁
 * 线程X 打印比较
 */
class Show{
    private Lock lock = new ReentrantLock();
    //3个通信
    private Condition condition1= lock.newCondition();
    private Condition condition2= lock.newCondition();
    private Condition condition3= lock.newCondition();

    private int flag = 1;
    public void printLnA() throws Exception {
        lock.lock();
        try{
            if(flag != 1){
                condition1.await();
            }

            if(flag ==1){

                for (int i = 0; i < 1; i++) {
                    System.out.println(Thread.currentThread().getName());
                }

                //todo 交替唤醒，取告诉condition2唤醒
                flag = 2;
                condition2.signal();
            }


        }catch (Exception e){

        }finally{
            lock.unlock();
        }
    }
    public void printLnB() throws Exception {
        lock.lock();
        try{
            if(flag != 2){
                condition2.await();
            }

            if(flag ==2){
                for (int i = 0; i < 1; i++) {
                    System.out.println(Thread.currentThread().getName());
                }
                flag = 3;
                condition3.signal();
            }

        }catch (Exception e){

        }finally{
            lock.unlock();
        }
    }
    public void printLnC() throws Exception {
        lock.lock();
        try{
            if(flag != 3){
                condition3.await();
            }
            for (int i = 0; i < 1; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            flag = 1;
            condition1.signal();
        }catch (Exception e){

        }finally{
            lock.unlock();
        }
    }
}
