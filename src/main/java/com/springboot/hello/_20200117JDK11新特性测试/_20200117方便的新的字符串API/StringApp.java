package com.springboot.hello._20200117JDK11新特性测试._20200117方便的新的字符串API;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StringApp {

    @Test
    public void stringAPIFunction() {
        //通用的判断
        String str = getStr();
        assertFalse(str.isEmpty());

        //判断是否为空，但是基础是必须有内容，""起步
        String emptyStr = getEmptyStr();
        assertTrue(emptyStr.isEmpty());
        assertTrue(emptyStr.isBlank());

        //判断String的判断空支付，判断去除空格
        String nullStr = getNullStr();
        assertThrows(NullPointerException.class, () -> nullStr.isEmpty());
        assertThrows(NullPointerException.class, () -> nullStr.isBlank());

        /**
         * strip() 去除首尾两端的空格
         * stripLeading() 去除首的空格
         * stripTrailing() 去除尾部空格
         *
         * 以上三者判断方法，都不允许null
         */
        assertEquals("hello world", getStrWithStrip().strip());

        assertEquals("hello world  ", getStrWithStrip().stripLeading());

        assertEquals("  hello world", getStrWithStrip().stripTrailing());

        //把字符串复制几次字符串拼接
        assertEquals("hello worldhello world", getStr().repeat(2));

        //统计字符串的字符行数
        Stream<String> lines = getStr().lines();
        assertEquals(1,lines.count());
    }

    private String getStr() {
        return "hello world";
    }

    private String getEmptyStr() {
        return "";
    }

    private String getNullStr() {
        return null;
    }

    private String getStrWithStrip() {
        return "  hello world  ";
    }
}
