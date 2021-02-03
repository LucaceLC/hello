package com.springboot.leetcode.数._2021020303整数反转;

public class App {
    public int reverse(int x) {
        /**
         * 取余数
         * while叠加
         * 反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0
         * 强制转换的用法
         */
        long result = 0;
        while ( x != 0){
            result = result * 10 + x % 10;
            x /= 10;
        }
        return  (int) result == result ? (int) result : 0;
    }
}
