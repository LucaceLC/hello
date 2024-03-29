package com.springboot.hello._2023060601JUC._2021030401自旋锁的实现与原理;

public class App {

    /**
     * 第一问题，什么是自旋锁
     *    当一个线程尝试取获取锁时，如果锁已经被其他线程占用，那么该线程一直循环等待，直到获取到锁，这个线程不会被挂起
     *
     *    换句话说，多个线程并行执行时，如果一个线程尝试获取锁时，有另一个线程占用，此时线程不挂机，而是继续占用cpu的执行时间，
     *    让当前线程执行一个true循环（自旋），直到获取到锁
     *
     * 第二个问题，什么是自旋CAS
     *    利用JUC包中的原子类的cas比较替换，cas的比较替换是一种乐观锁的机制
     *    如果当前线程没有比较替换成功，没有获取到锁，那么线程一直while循环等待，
     *    通过不断循环判断，锁有没有被其他线程持有，直到设置成功，表示获取锁成功
     *    释放锁时，把原子类设置为null
     *    像int的原子类，自增减和数值操作都有自旋
     *
     * 第三个问题，自旋有什么缺点
     *   如果线程冲突严重的请款下，抢占锁比较频繁，那么会造成自旋时间过长，默认jdk的自旋次数是10，如果草果这个自旋次数，线程会挂起
     *
     * 第四个问题，自旋CAS什么情况下适用
     *   多个线程频繁抢占锁资源，自旋会大幅降低性能，cas自旋只适合抢占锁竞争比较少的情况
     *   这个时候，使用同步锁进行线程的阻塞和唤醒，性能更好
     *
     * 第五个问题，那么什么是自适应自选锁
     *   线程获取锁时，它的自旋时间由上一个获取该锁的线程的自旋时间和状态决定
     *   例如，一个线程刚通过自旋等待时间限制刚好获取到锁，jvm会让自旋时间延长
     *        如果在自旋时间内，线程很少成功，那么jvm可能会忽律自旋操作
     *
     *
     */
}
