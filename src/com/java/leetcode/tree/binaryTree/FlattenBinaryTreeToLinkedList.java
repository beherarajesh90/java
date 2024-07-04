package com.java.leetcode.tree.binaryTree;

import com.java.leetcode.tree.TreeNode;

public class FlattenBinaryTreeToLinkedList {

    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }

//    public void flatten(TreeNode root) {
//        if (root == null) return;
//        flatten(root.left);
//        flatten(root.right);
//        if (root.left != null){
//            TreeNode temp = root.right;
//            root.right = root.left;
//            if (temp!=null){
//                TreeNode cur = root.left;
//                while (cur.right!=null){
//                    cur=cur.right;
//                }
//                cur.right = temp;
//            }
//        }
//        root.left=null;
//    }
}
