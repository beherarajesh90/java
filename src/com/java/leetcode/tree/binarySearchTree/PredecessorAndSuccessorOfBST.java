package com.java.leetcode.tree.binarySearchTree;

import com.java.leetcode.tree.TreeNode;

public class PredecessorAndSuccessorOfBST {
    public static TreeNode findInorderPredecessor(TreeNode root){
        TreeNode node = root.left;
        while (node!=null && node.right!=null){
            node=node.right;
        }
        return node;
    }

    public static TreeNode findInorderSuccessor(TreeNode root){
        TreeNode node = root.right;
        while (node!=null && node.left!=null){
            node=node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(50);
        TreeNode node2 = new TreeNode(30);
        TreeNode node3 = new TreeNode(70);
        TreeNode node4 = new TreeNode(20);
        TreeNode node5 = new TreeNode(40);
        TreeNode node6 = new TreeNode(60);
        TreeNode node7 = new TreeNode(80);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        TreeNode predecessor = findInorderPredecessor(node1);
        TreeNode successor = findInorderSuccessor(node1);

        System.out.println("Predecessor: "+predecessor.val+" Successor: "+successor.val);
    }
}
