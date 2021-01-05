package com.springboot.leetcode.链表._2020102601链表判断是否有环;

import java.util.HashSet;
import java.util.Set;

/**
 * 单链列表的定义
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {

    //hash
    public boolean hasCycleWithHash(ListNode head){
        Set<ListNode> listNodeSet = new HashSet<>();
        while (head != null){
            if(!listNodeSet.add(head)){
               return true;
            }
            else {
                head = head.next;
            }
        }
        return false;
    }

    //do while
    public boolean hasCycleWithFastSlow(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        do {

            //判断前面的兔子有没有走到头，走到头，跳出循环
            if (fast == null || fast.next == null) {
                return false;
            }
            //自身移动
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != slow);

        return true;
    }

    //while
    public boolean hasCycleMethod(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
        next = null;
    }
}

class Test{

    //20201028
    public boolean hasCycleWithFastSlow(ListNode listNode){
        //龟兔赛跑
        if(listNode == null || listNode.next == null) return false;

        //同时起跑
        ListNode faste = listNode;
        ListNode solw = listNode;

        do {
            //判断兔子
            if(faste == null || faste.next == null){
                solw = solw.next;
                faste = faste.next.next;
            }

        }while (faste != solw);
        return true;
    }
}

