package com.springboot.hello._2023060501互联网高并发设计题._2023060703MD5的摘要算法是怎么实现的;

public class App {
    /**
     * md5是第五代摘要算法，不安全，主要作为校验数据是否被揣改
     *
     * 原数据，追加位数到512位的N倍  追加1和若干个0
     *
     * 定义初始化4个128位的hash值，ABCD
     *
     * 分成若干个512位的组
     *
     * 每组拆分成16组
     *
     * 每组进行与或非位移运算，结果累加
     *
     * 得到最后128位，输出为16进制的32位的值
     */
}
