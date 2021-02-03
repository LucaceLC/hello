package com.springboot.leetcode.图._2021012201拓扑排序;

import java.util.LinkedList;
import java.util.Queue;

public class App {

    public int[] 拓扑排序(int intCourses,int[][] courseCombinations){

        /**
         * 什么是拓扑排序，
         * 针对的无环Character.isLetterOrDigit向图
         *     核心点：顶点
         *            边
         *            出度，入度
         *
         *            什么是顶点：入度为0，顶点
         *            什么是边：指向关系叫边
         *            什么是入度：指向自己的边的个数
         *            什么是出度：指向别人的别数个数
         *
         * 场景：课程输出，前置课程学习完，才能学习下一个课程
         *
         * 最小堆实现拓扑排序，
         *
         * 首先计算所有点的入度，如果入度为0，是为顶点，用Queue保存，弹出放入结果
         *
         * 然后循环比较，入度减-
         *
         * 循环遍历
         */
        //结果
        int[] result = new int[intCourses];
        //入度
        int[] intRudu = new int[intCourses];
        //[1,0] [2,1] [3,0],[2,4]
        //int[1] = 1 int[0] = 0
        for (int[]  combination : courseCombinations){
            int first = combination[0];
            //计算所有点的入度
            intRudu[first] ++;
        }

        Queue<Integer> queue = new LinkedList<>();
        //如果入度为0，放入队列
        for (int i = 0; i < intCourses; i++) {
            if(intRudu[i] == 0){
                queue.offer(i);
            }
        }

        //设置结果数组的起始位置
        int index = 0;
        while ( !queue.isEmpty()){
            Integer pollNumber = queue.poll();
            result[index] = pollNumber;
            index++;

            for (int[]  combination : courseCombinations){
                //第二个元素 指向第一个元素 [1,0] [2,1]
                int second = combination[1];
                //顶点已经被移出去了，那么相应的他自己的入度-1
                if(pollNumber == second){
                    int selfNumber = combination[0];
                    intRudu[selfNumber] --;

                    //校验自己的入度是不是为0，如果是0，那么就放入栈
                    if(intRudu[combination[0]] == 0){
                        queue.offer(combination[0]);
                    }
                }
            }
        }
        return index == intCourses ? result : new int[]{};
    }
}
