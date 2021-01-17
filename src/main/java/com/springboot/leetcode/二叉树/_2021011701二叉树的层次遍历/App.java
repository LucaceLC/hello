package com.springboot.leetcode.二叉树._2021011701二叉树的层次遍历;

import java.util.*;

public class App {
    /**
     * TreeNode
     *     二次树的层次遍历
     */

    public List<List<Integer>> 二叉树的层次遍历 (TreeNode root){
        /**
         * 首先需要一个队列进行循环
         *
         * 先遍历根节点，如果根节点不为空，取出所有的节点的值，放入List
         *
         * 在每次队列元素遍历的时候，遍历的次数是队列的个数
         *
         * 如果当前节点的左右节点不为空，加入到队列中，会在队列的尾部
         *
         * 循环遍历即可
         */
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        //能继续执行循环，队列中一定有Node节点
        while (!queue.isEmpty()){
            int size = queue.size();

            //每次都有弹出和弹入，所有第一是先遍历完一层，再遍历一层
            List<Integer> oneList = new ArrayList<>();
            //for循环是循环每层的节点，所以节点的值结果要在循环外
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int value = node.value;
                oneList.add(value);
                //尾部插入队列
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            //循环完
            result.add(oneList);
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
