package com.kuber.leetcode.swordtooffer;


import java.util.Deque;
import java.util.LinkedList;

/*剑指 Offer 28. 对称的二叉树*/
public class exam28 {


    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null) return false;
        return leftNode.val == rightNode.val && check(leftNode.left, rightNode.right) && check(leftNode.right, rightNode.left);
    }
}
