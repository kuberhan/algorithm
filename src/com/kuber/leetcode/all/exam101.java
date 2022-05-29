package com.kuber.leetcode.all;


/*对称二叉树*/

/*
 * 中序遍历树，将数组存在list中，然后双指针遍历数组，看数组是否对称。这种方法不行！例如：树[1,2,2,2,null,2]
 * */
public class exam101 {

    public boolean isSymmetric(TreeNode root) {
        TreeNode p = root;
        TreeNode q = root;
        return check(p, q);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

}
