package com.kuber.leetcode.all;

import java.util.HashMap;

/*105. 从前序与中序遍历序列构造二叉树*/
public class exam105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return divide(preorder, 0, 0, inorder.length - 1, map);
    }

    public TreeNode divide(int[] preorder,int root, int left, int right, HashMap<Integer, Integer> map){
        if (left > right) return null;
        TreeNode node = new TreeNode(preorder[root]);
        Integer i = map.get(preorder[root]);
        node.left = divide(preorder, root + 1, left, i - 1, map);
        node.right = divide(preorder, root + (i - left) + 1, i + 1, right, map);
        return node;
    }
}
