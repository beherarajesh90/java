package com.java.leetcode.tree.binarySearchTree;

import com.java.leetcode.tree.TreeNode;

public class KthSmallestElementInABST {

    private int ans, kth;
    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        kthSmallestHelper(root);
        return ans;
    }

    private void kthSmallestHelper(TreeNode root){
        if (root == null) return;
        kthSmallestHelper(root.left);
        if (kth == 1) ans = root.val;
        kth--;
        kthSmallestHelper(root.right);
    }
}
