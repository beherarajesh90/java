package com.java.leetcode.tree.binarySearchTree;

import com.java.leetcode.tree.Node;

public class RemoveBSTKeysOutsideTheGivenRange {
    public static Node removeOutsideRange(Node root, int min, int max) {

        if(root==null) return null;

        if(root.data<min){
            return removeOutsideRange(root.right, min, max);
        }else if(root.data>max){
            return removeOutsideRange(root.left, min, max);
        }else{
            root.left = removeOutsideRange(root.left, min, max);
            root.right = removeOutsideRange(root.right, min, max);
        }
        return root;
    }
}
