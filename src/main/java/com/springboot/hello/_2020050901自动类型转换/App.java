package com.springboot.hello._2020050901自动类型转换;

import org.junit.jupiter.api.Test;

public class App {

    @Test
    public void autoConvert() {

        /**
         * 自动类型转换的核心
         *  小的数据类型，自动，大的数据类型
         *
         *  long->float可能会失去精度
         *
         *  byte short int long
         *
         *              float double
         */
        byte a =1;
        short b = a;
        int c = b;
        long d = c;
        float e = d;
        double f = e;
    }
}
