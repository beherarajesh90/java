package com.java.leetcode.tree.binarySearchTree;

import com.java.leetcode.tree.TreeNode;

public class MinimumAbsoluteDifferenceinBST {
    private int min, prev;
    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        prev = Integer.MAX_VALUE;
        getMinimumDifferenceHelper(root);
        return min;
    }

    private void getMinimumDifferenceHelper(TreeNode root){
        if (root == null) return;
        getMinimumDifferenceHelper(root.left);
        min = Math.min(min,Math.abs(root.val-prev));
        prev = root.val;
        getMinimumDifferenceHelper(root.right);
    }
}
