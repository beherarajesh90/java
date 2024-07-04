package com.java.leetcode.tree.binaryTree;

import com.java.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightSideViewHelper(root,list,0);
        return list;
    }

    private void rightSideViewHelper(TreeNode root, List<Integer> list, int curDepth) {
        if(root==null) return;
        if(curDepth == list.size()) list.add(root.val);
        rightSideViewHelper(root.right, list, curDepth+1);
        rightSideViewHelper(root.left, list, curDepth+1);
    }
}
