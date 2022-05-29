package com.kuber.leetcode.swordtooffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*剑指 Offer 34. 二叉树中和为某一值的路径*/
public class exam34 {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        dfs(root, target, path, res);
        return res;
    }

    public void dfs(TreeNode root, int target, List<Integer> path, List<List<Integer>> res){
        //结束标志
        if (root == null) return;
        path.add(root.val);
        if (target - root.val == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, target - root.val, path, res);
        dfs(root.right, target - root.val, path, res);
        path.remove(path.size() - 1);
    }


}
