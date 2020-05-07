package com.springboot.hello._2020050702赋值运算符与扩展;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class App {

    @Test
    public void operationWithFunction() {
        /**
         * =作为正常的赋值运算符，把右边的值赋给左边的变量
         *
         * += -= *= /= %=扩展赋值运算符，把右边作为一个整体去运算的
         */
        int a = 3;
        int b = 2;
        b*= 3; // b = b*3
        Assertions.assertEquals(6,b);

        a += b+3;  // a = a + (b+3) 右边优先计算
        Assertions.assertEquals(12,a);
    }
}
