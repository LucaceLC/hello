package com.springboot.hello._20200216JUC._2021010301并发修改异常测试;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ExceptionListRunnable {

    //引发并发修改异常
    @Test
    public  void errorRunnable() {
        ErrorRunnable errorRunnable = new ErrorRunnable();
        for (int i = 0; i < 10; i++) {
            new Thread(errorRunnable).start();

        }

    }

    //CopyOnWriteArrayList 复制并写入集合，线程安全的
    @Test
    public  void successRunnable() {
        SuccessRunnable successRunnable = new SuccessRunnable();

        for (int i = 0; i < 10; i++) {
            new Thread(successRunnable).start();

        }
    }
}

class ErrorRunnable implements Runnable{
    //测试并发修改异常  java.util.ConcurrentModificationException
    private static List<String> numberList = Collections.synchronizedList(new ArrayList<>());
    static {
        numberList.add("AA");
        numberList.add("BB");
    }

    //多个线程同时操作一个List，有遍历又又更新时，synchronizedList会出现并发修改异常，
    @Override
    public void run() {
        numberList.forEach(number->{
            System.out.println(number);
            numberList.add("CC");
        });
    }
}

/**
 * CopyOnWriteArrayList,复制并写入
 * 当List在并发操作时，有修改时，会在底层创建一个新集合，copy元素
 *
 * 并发操作下，遍历多于更新，使用CopyOnWriteArrayList，效率高
 * 当更新操作多时，不建议使用CopyOnWriteArrayList
 */
class SuccessRunnable implements Runnable{
    private static List<String> numberList = new CopyOnWriteArrayList<>();
    static {
        numberList.add("AA");
        numberList.add("BB");
    }

    @Override
    public void run() {
        numberList.forEach(number->{
            System.out.println(number);
            numberList.add("CC");
        });
    }
}
