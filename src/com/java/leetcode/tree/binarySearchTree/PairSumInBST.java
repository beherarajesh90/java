package com.java.leetcode.tree.binarySearchTree;

import com.java.leetcode.tree.Node;

import java.util.Stack;

public class PairSumInBST {

    static boolean findPair(Node root, int X)
    {
        return findPairOptimized(root,X);
        // List<Integer> list = new ArrayList<>();
        // inorderTraversal(root, list);
        // return isPairSumPresent(list, X);
    }



    static boolean  findPairOptimized(Node root, int X)
    {
        Stack<Node> left = new Stack<>();
        Stack<Node> right = new Stack<>();

        pushAllLeft(root, left);
        pushAllRight(root, right);

        boolean res = false;
        while(!left.isEmpty() && !right.isEmpty() && left.peek().data!=right.peek().data){
            Node curLeft = left.peek();
            Node curRight = right.peek();
            if(curLeft.data+curRight.data == X){
                res = true;
                break;
            }

            if(curLeft.data+curRight.data < X){
                Node poppedLeft = left.pop();
                pushAllLeft(poppedLeft.right, left);
            }else{
                Node poppedRight = right.pop();
                pushAllRight(poppedRight.left, right);
            }
        }
        return res;
    }

    static void pushAllLeft(Node node, Stack<Node> stack){
        Node cur = node;
        while(cur!=null){
            stack.push(cur);
            cur=cur.left;
        }
    }

    static void pushAllRight(Node node, Stack<Node> stack){
        Node cur = node;
        while(cur!=null){
            stack.push(cur);
            cur=cur.right;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(8);
        Node n2 = new Node(3);
        Node n3 = new Node(9);
        Node n4 = new Node(1);
        Node n5 = new Node(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        System.out.println(findPairOptimized(n1,4));
    }
}
