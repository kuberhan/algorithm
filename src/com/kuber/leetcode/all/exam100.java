package com.kuber.leetcode.all;

/*相同的树*/

/*100和101解法相同，无语了*/
public class exam100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return check(p, q);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && check(p.left, q.left) && check(p.right, q.right);
    }

}
