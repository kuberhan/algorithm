package com.kuber.leetcode.all;

import java.util.ArrayList;
import java.util.List;
/*
94.二叉树的中序遍历
* 跟144，145同一题型，一个模板直接干到底
* */
public class exam94 {

    /*
    二叉树的中序遍历
    */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        addNode(root, list);
        return list;
    }

    public void addNode(TreeNode root, List<Integer> list) {
        if (root == null) return;
        addNode(root.left, list);
        list.add(root.val);
        addNode(root.right, list);
    }

}
