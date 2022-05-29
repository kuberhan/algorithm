package com.kuber.leetcode.all;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class exam113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, path, targetSum, res);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> path, int targetSum, List<List<Integer>> res) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                res.add(new LinkedList<>(path));
            }
        }
        dfs(root.left, path, targetSum - root.val, res);
        dfs(root.right, path, targetSum - root.val, res);
        path.remove(path.size() - 1);
    }
}
