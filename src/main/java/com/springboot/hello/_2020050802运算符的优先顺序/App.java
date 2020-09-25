package com.springboot.hello._2020050802运算符的优先顺序;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class App {

    @Test
    public void orderOperation() {
        /**
         * 运算符的顺序不必全部记住
         *
         * 核心：
         * （）优先，单元运算符优先，逻辑与 > 逻辑或
         */

        boolean a = true;
        boolean b = true;
        boolean c = false;

        //优先 b&&c
        boolean result = a || b && c;

        Assertions.assertTrue(result);
    }
}
