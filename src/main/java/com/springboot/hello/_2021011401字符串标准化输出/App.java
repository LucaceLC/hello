package com.springboot.hello._2021011401字符串标准化输出;

import org.junit.jupiter.api.Test;

public class App {

    public static void main(String[] args) {
        /**
         * 字符标准化输出
         * String.format();
         *
         * String.format("%-0m.n 格式"，num)；
         *              -左边对齐
         *              0m 一共的位数，不够补0
         *              .n小数点位数
         * @Url https://blog.csdn.net/lonely_fireworks/article/details/7962171
         *
         * 格式
         *      int           %d
         * 		float/double  %f
         * 		char          %c
         * 		String        %s
         */
        int number = 1;
        System.out.println(String.format("%02d",number));//01

        number = 10;
        System.out.println(String.format("%02d",number));//10

        number = 111;
        System.out.println(String.format("%02d",number));//11

    }

    @Test
    public void 转化格式测试(){
        String str=null;
        str=String.format("Hi,%s", "王力");
        System.out.println(str);
        str=String.format("Hi,%s:%s.%s", "王南","王力","王张");
        System.out.println(str);
        System.out.printf("字母a的大写是：%c %n", 'A');
        System.out.printf("3>7的结果是：%b %n", 3>7);
        System.out.printf("100的一半是：%d %n", 100/2);
        System.out.printf("100的16进制数是：%x %n", 100);
        System.out.printf("100的8进制数是：%o %n", 100);
        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50*0.85);
        System.out.printf("上面价格的16进制数是：%a %n", 50*0.85);
        System.out.printf("上面价格的指数表示：%e %n", 50*0.85);
        System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50*0.85);
        System.out.printf("上面的折扣是%d%% %n", 85);
        System.out.printf("字母A的散列码是：%h %n", 'A');
    }

    @Test
    public void 搭配转换符标志使用(){
        String str=null;
        //$使用
        str=String.format("格式参数$的使用：%1$d,%2$s", 99,"abc");
        System.out.println(str);
        //+使用
        System.out.printf("显示正负数的符号：%+d与%d%n", 99,-99);
        //补O使用
        System.out.printf("最牛的编号是：%03d%n", 7);
        //空格使用
        System.out.printf("Tab键的效果是：% 8d%n", 7);
        //.使用
        System.out.printf("整数分组的效果是：%,d%n", 9989997);
        //空格和小数点后面个数
        System.out.printf("一本书的价格是：% 50.5f元%n", 49.8);
    }
}
