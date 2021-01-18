package com.springboot.leetcode.二叉树._2021011801从上到下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class App {

    public int[] levelOrder(TreeNode root) {
        /**
         * 从根节点开始，从做到右打印
         *
         * 如果是空，返回0数组
         *
         * 不为空，先循环每层节点
         */
        if(root == null) return new int[0];
        int[] result = null;
        List<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                resultList.add(node.value);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }

        result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value) {
        this.value = value;
    }
}
