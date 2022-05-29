package com.kuber.leetcode.nowdoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NC15 {

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> path = new ArrayList<>();
            int cs = queue.size();
            for (int i = 0; i < cs; i++) {
                TreeNode poll = queue.poll();
                path.add(poll.val);
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            res.add(path);
        }
        return res;
    }
}
