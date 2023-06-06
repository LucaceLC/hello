package com.springboot.hello._2023060601JUC._2021020702读写锁;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class App {

    public static void main(String[] args) {
        /**
         * 读写锁
         * 什么是读写锁，
         * 多线程读写一个资源，读读不需要互斥，
         * 读写/写写需要互斥
         *
         * 读写锁维护了一对锁，一个读锁，一个写锁
         */


        WriteAndGet writeAndGet = new WriteAndGet();

        for (int i = 0; i < 200; i++) {
            new Thread(()->{
                writeAndGet.setNumber((int)(Math.random() * 101));
            },"write"+i).start();
        }
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                writeAndGet.getNumber();
            },"read"+i).start();
        }



    }
}


class WriteAndGet{
    private int number;
    //todo key
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public int getNumber() {
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        readLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+":"+number);
            return number;
        }catch (Exception e){

        }finally {
            readLock.unlock();
        }
        return -1;
    }

    public void setNumber(int number) {
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

        writeLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+":"+number);
            this.number = number;
        }catch (Exception e){
        }finally {
            writeLock.unlock();
        }
    }
}