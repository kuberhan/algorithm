package com.kuber.leetcode.all;

import com.kuber.leetcode.all.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
* 144. 二叉树的前序遍历
* 基础题。。。递归很简单，非递归稍微麻烦点
* */
public class exam144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public void preOrder(TreeNode root, List<Integer> res){
        if (root == null) return;
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }
}
