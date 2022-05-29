package com.kuber.leetcode.swordtooffer;

/*剑指 Offer 55 - I. 二叉树的深度*/
public class exam55_1 {

    /*是对递归遍历二叉树的一种变形*/
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth) + 1;
    }

}
