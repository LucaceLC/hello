package com.springboot.leetcode.数._2021020502有序数组包含负数取平方值然后再排序;

import java.util.stream.IntStream;

public class App {

    public int[] sort(int[] nums){
        return IntStream.of(nums).map(a->a * a).sorted().toArray();
    }


    //双指针解法
    public int[] sort2(int[] nums){
        int length =nums.length;
        int left = 0;
        int right = length -1;
        //索引 从尾部开始往前查找
        int index = length -1;
        //todo 千万不要用new int[index] index = length-1
        int[] result = new int[length];

        while (index >= 0){
            //从后往前

            if(nums[left] * nums[left] > nums[right] * nums[right]){
                result[index--] = nums[left] * nums[left];
                left ++;
            }
            else{
                result[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }


}
