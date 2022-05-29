package com.kuber.leetcode.swordtooffer;

/*剑指 Offer 54. 二叉搜索树的第k大节点*/
public class exam54 {
    //需要将其提成类变量，因为基本类型数据传入的指，并不是地址值，会随着方法的结束而结束
    int res,count;
    public int kthLargest(TreeNode root, int k) {
        this.count = k;
        inOrderTraversal(root);
        return res;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null ) return;
        inOrderTraversal(root.right);
        if (--count == 0) {
            res = root.val;
            return;
        }
        inOrderTraversal(root.left);
    }
}
