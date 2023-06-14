package com.springboot.hello._2023060801Java高级._2023061301垃圾回收机制._2023061301根可达性分析;

import java.util.ArrayList;
import java.util.List;

public class App {
    /**
     * 根可达性分析
     *
     * GC root节点作为起点，向下找出所有被引用的对象，这些是活跃对象，剩下的对象可以进行垃圾回收
     *
     * 方法区的静态变量引用的对象
     * 栈帧上的本地变量引用的对象
     * 方法区的静态常量引用的对象
     *
     * native方法引用的对象
     */

    //栈帧中的本地变量表
    public void method() {
        String str = "Hello World";
        // ...
    }
    //方法区中类静态属性引用的对象
    private static List<String> list = new ArrayList<>();

    // 常量引用的对象
    private static final String CONSTANT = "constant";

    // JNI引用的对象，native方法中引用的java对象
    private native void nativeMethod();
}
