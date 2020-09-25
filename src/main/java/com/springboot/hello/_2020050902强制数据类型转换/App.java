package com.springboot.hello._2020050902强制数据类型转换;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class App {

    @Test
    public void forciblyConvert() {
        double number = 2.99;
        int forciblyNumber = (int) number; //强制类型转换失去精度
        Assertions.assertEquals(2, forciblyNumber);

        char a = 'a';
        int b = a + 1;  //自动类型转换
        Assertions.assertEquals(98, b);
        Assertions.assertEquals('b', (char) b);  //强制类型转换

    }
}
