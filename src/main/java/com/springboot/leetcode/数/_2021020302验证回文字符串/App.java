package com.springboot.leetcode.数._2021020302验证回文字符串;
public class App {

    public boolean isPalindrome(String str){
        str = str.toLowerCase();
        /**
         * 首先全部转成小写
         * 双指针循环
         * 判断单个字符是否是字母和数字
         */
        int start = 0;
        int end = str.length() -1;
        while (start <= end){
            if(!Character.isLetterOrDigit(str.charAt(start))){
                start ++; continue;
            }
            if(!Character.isLetterOrDigit(str.charAt(end))){
                end --; continue;
            }

            if( str.charAt(start) != str.charAt(end)){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(String str){

        str = str.toLowerCase();
        /**
         * 首先全部转成小写
         * 双指针循环
         * 判断单个字符是否是字母和数字
         */
        int start = 0;
        int end = str.length() -1;
        while (start <= end){
            if(!Character.isLetterOrDigit(str.charAt(start))){
                start ++; continue;
            }
            if(!Character.isLetterOrDigit(str.charAt(end))){
                end --; continue;
            }

            if( str.charAt(start) != str.charAt(end)){
                return false;
            }
        }
        return true;
    }
}
