package com.kuber.leetcode.all;

public class exam104 {

    public int maxDepth(TreeNode root) {
        int LD, RD;
        if (root == null) return 0;
        else{
            LD = maxDepth(root.left);
            RD = maxDepth(root.right);
            return (LD>RD?LD:RD)+1;
        }
    }
}
