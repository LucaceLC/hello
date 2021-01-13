package com.springboot.hello._2021011301生成随机数的方法;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        /**
         * 随机数方法
         *  1当前时间戳取余数
         *  2Math.random
         *  3new Random
         */

        long l = System.currentTimeMillis();
        //以下都是模拟 [0 100，包含0，不包含100
        int randomNumber = (int) (l % 100);
        System.out.println(randomNumber);

        int mathRandom = (int)(Math.random() * 100);
        System.out.println(mathRandom);

        Random random = new Random();
        int randomNext = random.nextInt(100);
        System.out.println(randomNext);
    }

    @Test
    public void random类真随机(){
        //随机种子在最外面
        Random noRandom = new Random(10);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                int i1 = noRandom.nextInt(100);
                System.out.print(i1+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void random类伪随机(){
        for (int i = 0; i < 5; i++) {
            //每次组的随机种子是同一个
            Random noRandom = new Random(10);
            for (int j = 0; j < 8; j++) {
                int i1 = noRandom.nextInt(100);
                System.out.print(i1+" ");
            }
            System.out.println();
        }
    }
}
