package com.kuber.leetcode.all;


import com.kuber.leetcode.all.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
* 145. 二叉树的后序遍历
*
* 跟144一样，超级简单。。。
* */
public class exam145 {


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    public void postOrder(TreeNode root, List<Integer> res){
        if (root == null) return;
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }
}
