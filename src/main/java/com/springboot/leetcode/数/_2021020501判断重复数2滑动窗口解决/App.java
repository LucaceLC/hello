package com.springboot.leetcode.数._2021020501判断重复数2滑动窗口解决;

import java.util.HashSet;
import java.util.Set;

/**
 * 题意： 给一个k，如果nums[i] == nums[j] return true
 *       并且 j-i<= k
 *       j<=i+k, i<n,j<=n-1
 */
public class App {
    //解法一，暴力双重遍历
    public boolean check(int[] nums,int k){
        int length = nums.length;
        for (int i=0; i< length; i++){
            for (int j= i+1; j<= k+i && j<= length -1; j++){
                if(nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    //暴力破解的优化
    public boolean checkBetter(int[] nums,int k){
        /**
         * 题意： 给一个k，如果nums[i] == nums[j] return true
         *       并且 j-i<= k
         *       j<=i+k, i,j<n
         */

        //解法一，暴力双重遍历
        int length = nums.length;
        for (int i=0; i< length; i++){
            int limit = Math.min(length -1 , k+i);
            for (int j= i+1; j<= limit; j++){
                if(nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    public boolean checkBest(int[] nums,int k){
        /**
         * 题意： 给一个k，如果nums[i] == nums[j] return true
         *       并且 j-i<= k
         *       j<=i+k, i,j<n
         *       size() == k+1 到达边界区间，那么就要开始把第一个元素移除掉
         *  0  1 2 3
         *【1，2，3,4,5，2】 ， 2
         *
         * 有一个set存放元素，set大小最大 == k+1
         * 1-> set ok  0  k=2
         * 2-> set ok  1
         * 3-> set ok  2 这里是最大长度，remove 1 i=2 k=2 i-k = 0
         * 4-> set ok  3 在4的时候，要移除1， i=3 k=2 要移除的是2
         * 5-> set ok  4
         * 2-> set 超过限制， 3 remove 1 索引0, 继续加入 k=2
         * 如果包含直接返回return
         */
        int length = nums.length;
        if(length <2) return false;
        Set<Integer> set = new HashSet<>();
        for (int i=0; i< length; i++){
            if(set.contains(nums[i])) return true;

            set.add(nums[i]);
            if(set.size() == k+1){
                //index_i - index_0 = k  -> index_0 = index_i - k
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    //推荐这种写法，把contains和add合并为一次判断
    public boolean checkBestBest(int[] nums,int k){
        int length = nums.length;
        if(length <2) return false;
        Set<Integer> set = new HashSet<>();
        for (int i=0; i< length; i++){
            //表示不重复
            if(set.add(nums[i])){
                if(set.size() == k+1){
                    //index_i - index_0 = k  -> index_0 = index_i - k
                    set.remove(nums[i-k]);
                }
            }
            else {
                return true;
            }
        }
        return false;
    }
}
