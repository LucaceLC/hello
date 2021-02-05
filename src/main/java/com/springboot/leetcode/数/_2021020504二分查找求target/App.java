package com.springboot.leetcode.数._2021020504二分查找求target;

public class App {

    public int search(int[] nums, int target){
        /**
         * 题意：有序升序数组，在某个节点旋转了，查target，要求时间复杂度小于O(n)
         * 使用二分查找
         * 前面一段，后面一段都是有序的
         * 找出旋转的点，changeIndex=-1
         * 然后二分查找
         */
        int length = nums.length;
        if(length == 0 ) return -1;
        if(length == 1) return nums[0] == target ? 0 : -1;

        int start=0,end = length -1;
        int changeIndex = -1;
        //一定会在某一个位置进行旋转 length-1
        for (int i = 0; i < length -1; i++) {
            if(nums[i]> nums[i+1]){
                changeIndex = i;
                break;
            }
        }
        int left = find(nums,start,changeIndex,target);
        int right = find(nums,changeIndex + 1, end,target);
        return left == -1 ? right : left;
    }

    private int find(int[] nums, int start,int end,int target) {
        /**
         * 二分查找
         * while循环
         * 条件 start<= end
         *
         * start = end - start /2 + start;中间
         */
        //两端都是升序
        while (start <= end){
            int mid = (end -start) /2 + start;
            int value = nums[mid];
            if(value == target) {
                return mid;
            }else if(value > target) {
              //todo 二分查找的关键在这里 mid-1 不断的二分查找，要以index_mid作为+1 -1的基础
              end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return -1;
    }
}
