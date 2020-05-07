package com.springboot.hello._2020050705字符串连接符;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class App {

    @Test
    public void strOperation() {
        /**
         * 两个知识点
         *  + 二元操作符，只要有一个是字符串，重载为字符串连接符
         *  + 的顺序是从左到右
         */
        String a = "5";
        int b = 4;
        int c = 5;

        Assertions.assertEquals("95",b+c+a);
    }
}
