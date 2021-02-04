package com.springboot.leetcode.二叉树._2021020404二叉树原地展开成链表;

public class App {

    /**
     *    1
     *   2 5
     * 3 4  6
     *
     * 先排右子树，用一个last保存， 然后排左子树
     * 排左子树的时候，last已经是右子树了，把las放到root节点的右变，就已经排好序了
     *
     * 到最后root节点已经原地展开了
     */
    TreeNode last = null;
    public void flatten(TreeNode root){
        flatten(root.rigth);
        flatten(root.left);
        root.rigth = last;
        root.left = null;
        last = root;
    }
}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode rigth;
}