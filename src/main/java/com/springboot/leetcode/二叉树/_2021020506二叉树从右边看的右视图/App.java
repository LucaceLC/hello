package com.springboot.leetcode.二叉树._2021020506二叉树从右边看的右视图;

import java.util.ArrayList;
import java.util.List;

public class App {

    List<Integer> result = new ArrayList<>();
    public List<Integer> findRightView(TreeNode root) {
        /**
         *  层序遍历，把所有节点放入List<>
         */
        List<TreeNode> nodeList = new ArrayList<>();
        if(root !=null ) nodeList.add(root);
        helper(nodeList);
        return result;
    }

    private void helper(List<TreeNode> nodeList){
        if(nodeList == null || nodeList.size() == 0) return;

        List<TreeNode> nextNodeList = new ArrayList<>();
        for(int i=0; i< nodeList.size(); i++){
            TreeNode node = nodeList.get(i);
            if(node.left != null) nextNodeList.add(node.left);
            if(node.right != null) nextNodeList.add(node.right);
            //取最后一个
            if(i == nodeList.size() -1) result.add(node.val);
        }
        helper(nextNodeList);
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value) {
        this.val = value;
    }
}