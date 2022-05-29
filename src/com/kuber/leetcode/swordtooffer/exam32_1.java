package com.kuber.leetcode.swordtooffer;


import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/*剑指 Offer 32 - I. 从上到下打印二叉树*/
/*即层次遍历二叉树*/
public class exam32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode visit = queue.poll();
            res.add(visit.val);
            if (visit.left != null)   queue.add(visit.left);
            if (visit.right != null)  queue.add(visit.right);
        }
        int[] resInts = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resInts[i] = res.get(i);
        }
        return resInts;
    }
}
