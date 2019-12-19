package com.springboot.hello._20191217反射机制._2019121901获取一个类的基本方法;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class App {

    @Test
    public void classFunction() throws Exception{
        Class<?> userClass = Class.forName("com.springboot.hello._20191217反射机制._2019121901获取一个类的基本方法.User");

        System.out.println(userClass);

        /**
         * class作为一种对象被管理
         *
         * 无论是定义的对象Class，还是基本数据类型型，数组的纬度，void类型都是一种Class对象
         *
         * 当类被加载到JVM时，jvm会创建一个Class对象，包含次类的所有结构和属性，有且只会创建一种
         */
        Class userClass2 = User.class;
        Class userClass3 = userClass;

        Assertions.assertTrue(userClass== userClass2  && userClass == userClass3);
        Class intClass = int.class;
        Class integerClass = Integer.class;

        int[] arrayInt = new int[10];
        int[][] secondArrayInt = new int[10][10];

        Class voidClass = void.class;


    }
}
