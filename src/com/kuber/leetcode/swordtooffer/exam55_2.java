package com.kuber.leetcode.swordtooffer;


/*剑指 Offer 55 - II. 平衡二叉树*/
public class exam55_2 {

    /*对二叉树深度的扩展，还是基于二叉树遍历的变形*/
    /*先序遍历+判断深度*/
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return (Math.abs(depth(root.left) - depth(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }


    public int depth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /*后序遍历+剪枝*/
    public boolean isBalanced2(TreeNode root) {
        return postOrder(root) != -1;
    }

    public int postOrder(TreeNode root){
        if (root == null) return 0;
        int left = postOrder(root.left);
        if(left == -1) return -1;
        int right = postOrder(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left,right) + 1 : -1;
    }
}
