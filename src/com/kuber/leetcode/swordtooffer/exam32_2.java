package com.kuber.leetcode.swordtooffer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*剑指 Offer 32 - II. 从上到下打印二叉树 II*/
public class exam32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)   return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            List<Integer> level = new ArrayList<>();
            //控制队列每次只处理一层的节点数，是对32_1基础层次遍历的变形
            for (int i = 0; i < currentSize; i++) {
                TreeNode leave = queue.poll();
                if (leave.left != null) {
                    queue.add(leave.left);
                }
                if (leave.right != null) {
                    queue.add(leave.right);
                }
                level.add(leave.val);
            }
            res.add(level);
        }
        return res;
    }
}
