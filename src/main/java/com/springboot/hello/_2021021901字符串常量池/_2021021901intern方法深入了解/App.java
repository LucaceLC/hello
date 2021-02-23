package com.springboot.hello._2021021901字符串常量池._2021021901intern方法深入了解;

import org.junit.jupiter.api.Test;

public class App {

    public static void main(String[] args) {
        /**
         * 1 intern方法在哪个类中，String类
         * 2 intern方法什么用，如果字符串常量池中，存在该字符串，直接返回该对象，
         *      如果不存在，创建对象加入字符串常量池，然后返回引用
         * 3 代码层面解释：
         *     System类，在加载时，会注册所有的native方法，在设置属性的初始化过程中，
         *     Version属性类会先初始化放入常量池中，包括java，版本号等
         *     1.8是Version 1.15是VersionProps
         * 4 涉及jdk1.7之后java用元空间替代永久代，元空间在堆上，jdk1.7之前，intern方法会把首次遇到的字符串复制示例到
         *      永久代的字符串常量池存储，StringBuilder则是在堆上创建一个对象
         *      jdk1.7之后，字符串常量池移到堆上，所以intern直接返回的是StringBuilder创建的对象的引用。
         *      而一些类常量，例如java，版本号等在系统类加载时，已经被初始化进常量池中，而StringBuilder是新创建一个对象
         *      自然是2个完全不同的对象
         *
         */
        //true
        String str1 = new StringBuilder().append("ali").append("baba").toString();
        System.out.println(str1 == str1.intern());

        //true
        String str2 = new StringBuilder().append("ja").append("va").toString();
        System.out.println(str2 == str2.intern());

        //Java(TM) SE Runtime Environment false
        String str3 = new StringBuilder().append("Java(TM) SE Runtime ").append("Environment").toString();
        System.out.println(str3 == str3.intern());
    }

    @Test
    public void printStringIntern(){
        /**
         * 返回字符串对象的规范表示。
         * 最初为空的字符串池由String类私有维护。
         * 调用intern方法时，如果池已经包含等于equals（Object）方法确定的此String对象的字符串，
         * 则返回池中的字符串。
         * 否则，将此String对象添加到池中，并返回对此String对象的引用。
         */
        String str1 = new StringBuilder().append("ali").append("baba").toString();
        System.out.println(str1);
        System.out.println(str1.intern());

        String str2 = new StringBuilder().append("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
    }
}
