package com.java.leetcode.tree.binaryTree;

import com.java.leetcode.tree.TreeNode;

public class DiameterOfABinaryTree {
    private int max_diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        max_diameter=0;
        diameter(root);
        return max_diameter;
    }

    private int diameter(TreeNode root){
        if(root==null) return 0;
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        max_diameter = Math.max(max_diameter, leftDiameter+rightDiameter);
        return Math.max(leftDiameter, rightDiameter) + 1;
    }
}
