package com.springboot.hello._2023060601JUC._2021010202模拟比较替换算法;

public class CompareAndSwapApp {

    /**
     * 思路
     * 三个方法
     * 获取value
     * 比较value
     * 设置value是否成功
     */
    public static void main(String[] args) {
       CompareAndSwap cas = new CompareAndSwap();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                int except = cas.get();
                boolean compareAndSwap = cas.compareAndSet(except, (int) (Math.random() * 101));
                System.out.println(compareAndSwap);
            }).start();
        }
    }

}


class CompareAndSwap{
    //内存值
    private int value;

    //获取
    public int get(){
        return value;
    }

    //比较并替换,返回旧值 模拟CAS算法，cpu底层的原子操作
    //永远都是返回最新读取的内存值
    public synchronized int compareAndSwap(int exceptedValue,int newValue){
        int oldValue = value;
        System.out.println("内存值value:" + oldValue);
        System.out.println("预期值exceptedValue:" + exceptedValue);
        System.out.println("新值:" + newValue);
        if(oldValue == exceptedValue){
            this.value = newValue;
        }

        return oldValue;
    }

    public synchronized boolean compareAndSet(int excepedValue, int newValue){
        return excepedValue == compareAndSwap(excepedValue,newValue);
    }
}