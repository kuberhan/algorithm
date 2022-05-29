package com.kuber.leetcode.swordtooffer;


/*剑指 Offer 27. 二叉树的镜像*/
public class exam27 {

    public TreeNode mirrorTree(TreeNode root) {
        exchangeTree(root);
        return root;
    }

    public void exchangeTree(TreeNode root){
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        exchangeTree(root.left);
        exchangeTree(root.right);
    }
}
