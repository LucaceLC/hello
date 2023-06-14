package com.springboot.hello._2023060801Java高级._2023061305普通循环的foreach循环的区别;

public class App {
    /**
     * 普通循环是根据get角标获取成员的
     * foreach是使用迭代器遍历元素的
     *
     * 因为有迭代器的创建的开销，普通循环更高效，但是实际开发中可以忽略不计
     * foreach可以会引发并发修改异常，一个线程遍历，另一个线程修改对象
     */
}
