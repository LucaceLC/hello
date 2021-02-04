package com.springboot.leetcode.数._2021020402判断是否有重复数;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class App {

    //一般解法
    public boolean check(int[] nums){
        //判断重复数，直接使用set解决
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size() != nums.length;
    }

    public boolean check2(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if(set.contains(num)){
                return true;
            }
        }
        return false;
    }
    //只是炫技，性能并不好
    public boolean check3(int[] nums){
        long count = IntStream.of(nums).distinct().count();
        return  count != nums.length;
    }

    //自己实现Set类的add方法，排序然后检查2个元素是否相等
    //关键点，先排序，然后遍历，遍历的退出条件是nums.length. -1
    public boolean check4(int[] nums){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -1; i++) {
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
