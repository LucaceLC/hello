package com.springboot.leetcode.链表._2020102701队列的最大值;

import java.util.ArrayDeque;
import java.util.Deque;

class MaxQueueWithQueue {
    private Deque<Integer> queue;
    //辅助的双端队列用来存储最大值
    private Deque<Integer> help;

    public MaxQueueWithQueue() {
        queue = new ArrayDeque<>();
        help = new ArrayDeque<>();
    }
    
    public int max_value() {
        return queue.isEmpty() ? -1 : help.peek();
    }

    public void push_back(int value) {
        //offer == offerLast 从尾部插入元素，主队列
        queue.offer(value);

        //辅助队列不为空，并且检索辅助队列的头/尾的元素。并且插入的值要大于这个值，那么就直接删除这个元素，然后删除，然后
        // >= 只保存最后一次的最大值， >保存所有的最大值
        while(!help.isEmpty() && value > help.peekLast()) {
            //删除双端队列的尾，弹出
            Integer integer = help.pollLast();
        }

        //辅助队列的尾巴插入一个元素
        help.offer(value);
    }
    
    public int pop_front() {
        if(queue.isEmpty()) {
            return -1;
        }

        //弹出第一个元素
        int val =  queue.pop();
        //检索双端队列的第一个元素


        //如果辅助最大值队列中，包含主队列弹出的值，对应的也删除一个，弹出
        if(help.peek() == val) {
            //弹出双端队列的第一个元素
            help.pop();
        }
        return val;
    }


    public static void main(String[] args) {
        MaxQueueWithQueue queue = new MaxQueueWithQueue();
        queue.push_back(1);
        queue.push_back(1);
        queue.push_back(2);
        queue.push_back(2);
        queue.push_back(3);
        queue.push_back(3);
        queue.push_back(4);
        queue.push_back(4);
        queue.push_back(5);
        queue.push_back(5);
        queue.push_back(6);
        queue.push_back(6);


        int popFront = queue.pop_front();
        System.out.println(popFront);
        int i = queue.max_value();
        System.out.println(i);




    }
}