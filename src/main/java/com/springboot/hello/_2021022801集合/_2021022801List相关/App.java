package com.springboot.hello._2021022801集合._2021022801List相关;

public class App {
    /**
     * List知识点
     *  ArrayList LinkedList Vector
     *
     *  ArrayList 有序 底层是数组 查询快，增删慢，线程不安全
     *      ArrayList的扩容，默认初始化容量是10
     *          检查索引
     *          扩容大小，elementDateCapacity>>1 + elementDateCapacity  =1.5倍
     *          底层是System.copyArray数组的复制
     *  LinkedList 有序，底层是连标 查询慢，增删快，线程不安全
     *          底层是双向链表
     *          元素是Node value,next,pre
     *          查询需要遍历所有，增删只要改变next和pre
     *  Vector底层实现和ArrayList相同，不同点是Vector线程安全，只为底层的方法有synchronized修饰
     *          虽然是线程安全，但是因为线程同步的原因，消耗了部分性能
     */

}
