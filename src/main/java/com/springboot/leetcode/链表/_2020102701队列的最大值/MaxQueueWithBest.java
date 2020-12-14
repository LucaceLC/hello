package com.springboot.leetcode.链表._2020102701队列的最大值;

class MaxQueueWithBest {

    // 栈
    private int[] stack;
    // 栈首位置
    private int front = 0;
    // 栈尾位置
    private int back = 0;
    // 从大到小排序
    private int[] sortedStack;  //自己用数组实现的双端队列
    private int sortedFront = 0;
    private int sortedBack = 0;

    public MaxQueueWithBest() {
        // 最多10000个元素
        stack = new int[10000];
        sortedStack = new int[10000];
    }

    //堆首位置==堆尾位置判断为空
    public boolean isEmpty() {
        return front == back;
    }

    //从已排序的堆上sortedStack，取第一个元素即可，最大堆，树结构
    public int max_value() {
        return sortedFront == sortedBack ? -1 : sortedStack[sortedFront];
    }

    //压入一个值
    public void push_back(int value) {
        stack[back] = value; //stack[0]=100 back尾巴就是1
        back++;

        //如果最大值，小于这个值，目的是求是求最大值，那么
        if (max_value() < value) {
            // 直接重置了，因为value在栈尾一定后出栈
            sortedFront = 0;
            sortedBack = 1;
            sortedStack[sortedFront] = value;
        }

        //新加入的值，比栈的最大值小，不动，x
        else {

            //数组的后面索引，要大于前置索引
            while (sortedBack > sortedFront && sortedStack[sortedBack - 1] < value) {
                // 丢弃在value之前，值更小的部分，这些出栈对max_value无影响
                sortedBack--;
            }
            sortedStack[sortedBack] = value;

            sortedBack++;
        }
    }
    
    public int pop_front() {
        if (isEmpty()) {
            return -1;
        }
        int value = stack[front++];
        if (max_value() == value) {
            sortedFront++;
        }
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