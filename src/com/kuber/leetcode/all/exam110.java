package com.kuber.leetcode.all;

/*
110题：二叉平衡树
* 方法一：自顶向下的递归
定义函数height，用于计算二叉树中的任意一个节点p的高度：
height = 0  root == null
height = max(root.left, root .right) + 1  root != null
* */
public class exam110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) > 1 ? false : isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
