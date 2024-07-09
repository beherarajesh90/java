package com.java.leetcode.tree.binaryTree;

import com.java.leetcode.tree.Node;

import java.util.ArrayList;

public class LeftViewOfBinaryTree {
    ArrayList<Integer> leftView(Node root)
    {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();
        leftViewHelper(root, list, 0);
        return list;
    }

    void leftViewHelper(Node root, ArrayList<Integer> list, int depth)
    {
        if(root==null) return;
        if(depth==list.size()){
            list.add(root.data);
        }
        leftViewHelper(root.left, list, depth+1);
        leftViewHelper(root.right, list, depth+1);
    }
}
