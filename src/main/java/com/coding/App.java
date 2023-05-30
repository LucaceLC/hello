package com.coding;

import java.util.HashMap;

public class App {
    /**
     * 给出一个序列list，求最大子序列的和 和对应的子序列
     * 2,3,4,1,-1,-10,-3,7,-6
     *   |
     */
    public int check(int[] arrays){
        //socket
        int result = arrays[0];
        int tempSum = 0;
        int rightIndex = arrays[1];
        //时间。IP,4随机数，100 redis
        int[] indexResult = new int[2];
        indexResult[0] = 0;
        for (int i = 0, arraysLength = arrays.length; i < arraysLength; i++) {
            int ele = arrays[i];
            //0 1 2 3
            if (tempSum > 0) {
                tempSum += ele;
            } else {
                tempSum = ele;
            }

            if(result > tempSum){

            }

        }

        return -1;
    }
}
