package com.springboot.leetcode.链表._2020102701队列的最大值;

class MaxQueueWithOneQueue {
    int[] q = new int[20000];
    int begin = 0;
    int end = 0;
    int maxValue = -1;
    public MaxQueueWithOneQueue(){
    }

    public int max_value(){
        if(begin == end) {
            return -1;
        }

        return maxValue;
    }

    public void push_back(int value) {
        q[end++] = value;
        maxValue = Math.max(maxValue,value);
    }

    public int pop_front(){
        if(begin == end) {
            return -1;
        }

        int value = q[begin];
        if(value == maxValue) {
            maxValue = q[begin+1];
            for(int i = begin+1;i<=end;i++){
                maxValue = Math.max(maxValue,q[i]);
            }
        }

        begin++;
        return value;
    }


}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */