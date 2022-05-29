package com.kuber.leetcode.all;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 98. 验证二叉搜索树(二叉排序树)
 * */
public class exam98 {

    /*方法1：中序遍历二叉树，添加到集合，如果集合已经按升序排好，那么就是二叉排序树，否则不是
    这种方法当然比不过递归，但是暴力解法，懂得都懂
    * */
    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i - 1) >= res.get(i)) return false;
        }
        return true;
    }

    public void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    /*递归做法，好好看，好好学*/
    public boolean isValidBST2(TreeNode root) {
        return childNodeIsValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean childNodeIsValid(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return childNodeIsValid(root.left, lower, root.val) && childNodeIsValid(root.right, root.val, upper);
    }

    /*非递归解法*/
    public boolean isValidBST3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long visit = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                if(root.val <= visit) return false;
                visit = root.val;
                root = root.right;
            }

        }
        return true;
    }


}
