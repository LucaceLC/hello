package com.springboot.hello._20200216JUC._2020121401并发问题原因;

public class 线程缓存导致的可见性问题 {

    //虽然解决了可见性问题，但是并没有加锁，保证并发性
    public volatile int number = 0;
    public static void main(String[] args) throws Exception {

        /**
         * 每个线程都有自己的独立内存空间
         *
         * 操作一个变量，读取内存的变量到缓存，然后改变值，最后再写回到内存空间去
         *
         * 2个线程的缓存是不可见的
         *
         */
        final 线程缓存导致的可见性问题 domain = new 线程缓存导致的可见性问题();
        Thread thread1 = new Thread(domain::add);
        Thread thread2 = new Thread(domain::add);

        thread1.start();
        thread2.start();

        thread2.join();
        thread1.join();

        //结果都是小于2w的
        System.out.println(domain.number);

    }
    public void add()  {
        for (int i = 0; i < 10000; i++) {
            number +=1;
        }
    }

}
