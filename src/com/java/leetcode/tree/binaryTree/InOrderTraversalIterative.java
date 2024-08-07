package com.java.leetcode.tree.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversalIterative {
    public static List< Integer > getInOrderTraversal(TreeNode root) {
        // Write your code here.

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;

        while(curNode!=null || !stack.isEmpty()){
            while(curNode!=null){
                stack.add(curNode);
                curNode = curNode.left;
            }
            curNode=stack.peek();
            stack.pop();
            result.add(curNode.data);
            curNode=curNode.right;
        }

        return result;
    }


    public static List< Integer > getInOrderTraversalConstantSpace(TreeNode root) {

        // Create answer array to store traversal.
        List < Integer > answer = new ArrayList< Integer >();

        // Base case.
        if (root == null) {
            return answer;
        }

        // 'PREDECESSOR' and 'CURRENT' will store predecessor and current nodes, respectively.
        TreeNode current, predecessor;

        // Initialize current node as 'ROOT'.
        current = root;

        // Run a loop until 'CURRENT' != NULL.
        while (current != null) {

            if (current.left == null) {

                // Add current node data to answer.
                answer.add(current.data);

                // Move to right child of current.
                current = current.right;
            } else {

                // Find predecessor of current node.
                predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    /*
                        Make a link between predecessor and current node
                        so that we have a path to come back to current
                        when we have traversed the whole left subtree.
                    */
                    predecessor.right = current;
                    current = current.left;
                } else {
                    /*
                        If right node of predecessor is not NULL then it
                        means we have traversed the whole left subtree.
                        So we unlink the connection between current and predecessor
                        and move to right node of current.
                    */
                    predecessor.right = null;
                    answer.add(current.data);
                    current = current.right;
                }
            }
        }

        // Return answer.
        return answer;
    }
}
