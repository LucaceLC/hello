package com.springboot.hello._2020102801静态初始化顺序;

public class Test{
    static int cnt = 6;
    static{
        cnt += 9;
    }

    public static void main(String[] args) {
        System.out.println("cnt =" + cnt);
    }

static{
    cnt /=3;
    };
}
