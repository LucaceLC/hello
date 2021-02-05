package com.springboot.leetcode.数._2021020505数组搜素插入元素的位置;

public class App {

    /**
     * [0,1,2,3,4]
     * eg 插入2，第一次出现nums[i] >= target return i
     *    如果一直都没有，index=length;
     *
     */
    //全部遍历
    public int find(int[] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }
    //二分查找 错误的
    public int find2(int[] nums,int target){
        int start=0, end = nums.length -1;
        while (start<= end){
            int mid = (end - start) /2 + start;
            int value = nums[mid];
            //todo 这里的判断条件错误，如果是【1，3，4，5】 2,这样一直都找不到，返回了length
            if(value == target){
                return mid;
            }else if(value > target){
                end = mid-1;
            }else {
                start = mid + 1;
            }
        }
        return nums.length;
    }

    public int searchInsert(int[] nums, int target) {
        int start=0, end = nums.length -1,result = nums.length;
        while (start<= end){
            int mid = (end - start) /2 + start;
            int value = nums[mid];
            //todo 只要出现了value > target就记录下来当时的索引，不断更新
            if(value >= target){
                result =  mid;
                end = mid-1;
            }else {
                start = mid + 1;
            }
        }
        return result;
    }
}
