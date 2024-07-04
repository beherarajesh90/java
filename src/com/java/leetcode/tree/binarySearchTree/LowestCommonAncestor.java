package com.java.leetcode.tree.binarySearchTree;

import com.java.leetcode.tree.TreeNode;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) return root;

        if(root==p || root==q) return root;
        TreeNode node = root;
        if(p.val < root.val && q.val < root.val){
            node = lowestCommonAncestor(root.left, p,q);
        }
        if(p.val > root.val && q.val > root.val){
            node = lowestCommonAncestor(root.right, p,q);
        }
        return node;
    }

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        while(root != null){
            if(root.val > p.val  && root.val > q.val){
                root = root.left;
            }else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }else{
                //root在[p,q] 或者是[q,p]之间 也可能是边界值
                return root;
            }
        }
        return root;
    }
}
