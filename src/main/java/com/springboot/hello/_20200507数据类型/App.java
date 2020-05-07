package com.springboot.hello._20200507数据类型;

public class App {

    public static void main(String[] args) {
        /**
         * 基本数据类型：4类 8小类
         *     整型，浮点型，字符型，布尔型
         *     byte short int long
         *     float double
         *     char
         *     boolean
         * 自动转换
         *
         * 默认类型
         *
         * 操作符与基本数据类型
         */

        byte a = 1;
        byte b = -128; //byte占1个字节，8位，范围-128-127；

        float c = 0.1f;
        float d = 0.2f; //浮点数据类型的默认类型是double；
        float e = c+d;  //操作float类型的计算

        double f = c + d; //会自动进行类型转换
        double g = e + 0.1;

    }
}
