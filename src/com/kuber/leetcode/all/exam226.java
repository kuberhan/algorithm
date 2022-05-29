package com.kuber.leetcode.all;

import com.kuber.leetcode.all.TreeNode;

public class exam226 {
    /*后序遍历*/
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    /*中序遍历*/
    public TreeNode invertTree2(TreeNode root) {
        if(root == null) return null;
        invertTree(root.left);
        TreeNode rightNode = root.right;
        root.right = root.left;
        root.left = rightNode;
        invertTree(root.left);
        return root;
    }

    /*先序遍历*/
    public TreeNode invertTree3(TreeNode root) {
        if(root == null) return null;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
