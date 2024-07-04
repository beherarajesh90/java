package com.java.leetcode.tree.binarySearchTree;

import com.java.leetcode.tree.TreeNode;

public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key < root.val)
            root.left = deleteNode(root.left, key);
        else if(key > root.val)
            root.right = deleteNode(root.right, key);
        else{
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            root.val = inorderSuccessor(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private int inorderSuccessor(TreeNode root){
        if(root.left==null) return root.val;
        return inorderSuccessor(root.left);
    }
}
