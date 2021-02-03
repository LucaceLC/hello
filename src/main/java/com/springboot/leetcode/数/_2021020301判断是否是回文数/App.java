package com.springboot.leetcode.数._2021020301判断是否是回文数;

public class App {

    /**
     * 数字判断回文数
     *   a不停/10，取余 加上去
     *
     *   负数，直接返回false
     * @param x
     * @return
     */
    public boolean isPalindrome(int x){
        if(x < 0) return false;
        if(x != 0 && x%10 ==0) return false;

        int lastNumber = 0;
        int tempNumber = x;

        /**
         * 初始化一个构造数，起始是0
         * 12321 取每次的余数，每取一次
         */
        while (tempNumber != 0) {
            //取每个的余数
            int carry = tempNumber % 10;

            //每次取到的余数加到末尾
            lastNumber = lastNumber * 10  + carry;

            //最后int类型/10 一定会是0
            tempNumber /= 10;
        }
        return x == lastNumber;
    }

    /**
     * 把回文数作为字符串处理
     * 双指针
     *
     * 循环条件 start <= end
     * 任意一次循环判断，charAt() ！= return false;
     * @param x
     * @return
     */
    public boolean isPalindromeWtihStr(int x){
        String str = Integer.toString(x);

        int start = 0;
        int end = str.length() - 1;

        while (start <= end){
            if(str.charAt(start) != str.charAt(end)) return false;
            start ++;
            end --;
        }

        //跳出循环，双指针相遇，一定是回文数
        return true;
    }
}
