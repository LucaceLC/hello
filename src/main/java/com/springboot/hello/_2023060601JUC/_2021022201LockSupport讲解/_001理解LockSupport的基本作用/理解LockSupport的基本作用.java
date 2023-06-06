package com.springboot.hello._2023060601JUC._2021022201LockSupport讲解._001理解LockSupport的基本作用;

public class 理解LockSupport的基本作用 {
    /**
     * LockSupport是什么
     *  对线程的等待唤醒的增强机制
     *  park和unpark方法作用是，用来阻塞和接触阻塞线程的
     *
     *  Objects类中的wait和notify，notifyAll方法必须与synchronized连用
     *  Lock类的Condition类的等待await 唤醒single，必须和lock，unlock连用
     *  需要注意的是，如果唤醒操作再等待之前，那么线程将一直等待，不会被唤醒
     */
}
