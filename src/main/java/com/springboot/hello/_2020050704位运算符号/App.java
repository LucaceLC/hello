package com.springboot.hello._2020050704位运算符号;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class App {

    @Test
    public void bitOperation() {
        /**
         * 位运算
         *  &  |  ～  >>  <<  ^
         *
         * 原码 反码 补码
         *
         * 正数的 三码相同
         * 负数的二进制表示，是其正数的补码
         *
         */
        int a = 5;    // 0101
        int b = 3;   //  0011

        int c = -5;
        /**
         * 5  0000 0000 0000 0000 0000 0000 0000 0101
         *    1111 1111 1111 1111 1111 1111 1111 1010  反码
         *    1111 1111 1111 1111 1111 1111 1111 1011  -5的二进制表示
         *    0000 0000 0000 0000 0000 0000 0000 0100
         */
        Assertions.assertEquals(1, a & b);
        Assertions.assertEquals(7, a | b);
        Assertions.assertEquals(6, a ^ b);
        Assertions.assertEquals(4, ~c);
        Assertions.assertEquals(2, a >> 1);
        Assertions.assertEquals(6, b << 1);
        Assertions.assertEquals(63, c >>> 26); //无符号又移动

    }

}
