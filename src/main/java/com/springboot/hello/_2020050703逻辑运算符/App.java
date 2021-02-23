package com.springboot.hello._2020050703逻辑运算符;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class App {

    @Test
    public void logicOperation() {
        /**
         * 逻辑运算符号的总类
         *
         * 逻辑的与或 & |  两边的boolean都会判断
         * 短路与或 && ||  短路优先
         * ！
         * ^ 异或 不同返回true，相同返回false
         */

        boolean a = false;
        boolean b = true;
        Assertions.assertEquals(false, a & b);
        Assertions.assertEquals(true, a | b);
        Assertions.assertEquals(false, a && b);
        Assertions.assertEquals(true, a || b);
        Assertions.assertEquals(true, !a);
        Assertions.assertEquals(true, a ^ b);

        Assertions.assertThrows(ArithmeticException.class,()->{boolean c = 1>3 & 1 > 3/0;});
        Assertions.assertEquals(false,1>3 && 1 > 3/0);
    }
}
