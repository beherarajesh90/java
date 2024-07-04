package com.java.leetcode.tree.binaryTree;

import com.java.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPreOrderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return buildBinaryTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }

    private static TreeNode buildBinaryTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {

        if (preStart>preEnd || inStart>inEnd) return null;

        TreeNode parent = new TreeNode(preorder[preStart]);
        int parentIndex = map.get(parent.val);
        int numsLeft = parentIndex - inStart;
        parent.left = buildBinaryTree(preorder,preStart+1,preStart+numsLeft, inorder,inStart,parentIndex-1, map);
        parent.right = buildBinaryTree(preorder,preStart+numsLeft+1, preEnd, inorder, parentIndex+1, inEnd, map);
        return parent;
    }
}
