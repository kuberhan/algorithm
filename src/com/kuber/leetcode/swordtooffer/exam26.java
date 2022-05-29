package com.kuber.leetcode.swordtooffer;

public class exam26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        //如果以A根节点的树不包含以B为根节点的树,则继续遍历，更换A树
        return contains(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }


    public boolean contains(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return contains(A.left, B.left) && contains(A.right, B.right);
    }

}
