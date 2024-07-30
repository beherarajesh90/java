package com.java.leetcode.tree.binaryTree;

import com.java.leetcode.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class LCAOfAnyNumberOfNodes {

    public static BinaryTreeNode<Integer> lcaOfThreeNodes(BinaryTreeNode<Integer> root, int node1, int node2,
                                                          int node3) {
        // Write your code here.
        if(root==null || root.data==node1 || root.data==node2 || root.data==node3) return root;

        BinaryTreeNode<Integer> leftResult = lcaOfThreeNodes(root.left, node1, node2, node3);
        BinaryTreeNode<Integer> rightResult = lcaOfThreeNodes(root.right, node1, node2, node3);

        if(leftResult!=null && rightResult!=null){
            return root;
        } else if(leftResult!=null){
            return leftResult;
        }else{
            return rightResult;
        }
    }
    public static int lcaOfThreeNodesGFG(Node root, int node1, int node2,
                                       int node3) {
        List<Integer> ancestors = new ArrayList<>();
        List<Integer> keyNodes = new ArrayList<>();
        keyNodes.add(node1);
        keyNodes.add(node2);
        keyNodes.add(node3);
        lcaOfNodes(root,keyNodes,0,ancestors);

        return ancestors.get(0);
    }

    private static int lcaOfNodes(Node root, List<Integer> keyNodes, int matchingNodesCount, List<Integer> ancestors) {

        if(root == null) return 0;

        matchingNodesCount = lcaOfNodes(root.left, keyNodes, matchingNodesCount, ancestors) +
                lcaOfNodes(root.right, keyNodes, matchingNodesCount, ancestors);

        if(keyNodes.contains(root.data)) matchingNodesCount++;

        if(matchingNodesCount == keyNodes.size()) ancestors.add(root.data);

        return matchingNodesCount;
    }

}

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}
