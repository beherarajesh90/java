package com.java.leetcode.tree.binaryTree;

import com.java.leetcode.tree.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p!=null && q!=null && p.val==q.val){
            boolean isLeftTreeSame = isSameTree(p.left, q.left);
            return isLeftTreeSame && isSameTree(p.right, q.right);
        }else return p == null && q == null;
    }
}
