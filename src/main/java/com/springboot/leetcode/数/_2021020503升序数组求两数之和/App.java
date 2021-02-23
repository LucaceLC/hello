package com.springboot.leetcode.数._2021020503升序数组求两数之和;

import java.util.HashMap;

public class App {

    //hash做法
    public int[] find(int[] nums, int target){
        int[] result = new int[2];
        /**
         * 求差值，target-nums[i] = differ
         * hash put(value,index);
         * 索引是从1开始
         */
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int differ = target - current;
            if(hashMap.containsKey(differ)){
                result[0] = hashMap.get(differ) + 1;
                result[1] = i +1;
            }
            else {
                hashMap.put(current,i);
            }
        }
        return result;
    }

    //因为本身是升序数组，用双指针做法
    public int[] find2(int[] nums, int target){
        int[] result = new int[2];
        /**
         * 双指针 start = 0 end = length-1
         * while循环
         * nums[start] + nums[end] == target return
         * else sum > target  end--
         * else sum< target start ++
         */
        int start = 0, end = nums.length -1;
        while (end >= start){
            int sum =  nums[start] + nums[end];
            if(sum == target){
                result[0] = start +1;
                result[1] = end +1;
                return result;
            }else if(sum > target){
                end--;
            }else {
                start++;
            }
        }
        return result;
    }
}
