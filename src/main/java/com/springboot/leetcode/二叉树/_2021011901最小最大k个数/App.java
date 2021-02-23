package com.springboot.leetcode.二叉树._2021011901最小最大k个数;

import java.util.*;

public class App {

    public int[] getLastNumbers(int[] arr,int k){
        /**
         * 获取最小的k个数
         * 使用jdk的优先队列 priorityQueue
         * 传入一个比较器
         *              会抛出异常  只是null/false  阻塞
         * 知识点 添加    add       offer        put
         *       删除    remove    poll         seek
         *       获取    element   peek
         */
        //min queue
        Queue<Integer> queue = new PriorityQueue<>(new MyComparator());
        int[] result = new int[k];

        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }

        return result;
    }


}
class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1-o2;
    }
}