package com.java.leetcode.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII {

    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }



    public static Node connect(Node root) {

        if (root == null) return root;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){
            int levelCount = queue.size();
            Node prevNode = null;
            for(int i=0; i<levelCount; i++){
                Node curNode = queue.poll();
                if (prevNode != null) prevNode.next = curNode;
                prevNode = curNode;
                if(curNode.left!=null) queue.offer(curNode.left);
                if(curNode.right!=null) queue.offer(curNode.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;

        n1 = connect(n1);

        while (n1!=null){
            System.out.println(n1.val);
            n1=n1.next;
        }
    }

//    using recursion
    private boolean hasChildren(Node node) {
        return node.left != null || node.right != null;
    }

    private Node getNextParent(Node root) {
        Node next = root.next;
        while (next != null && !hasChildren(next)) next = next.next;
        return next;
    }

    private void connectCousins(Node root) {
        if (!hasChildren(root)) return;
        Node nextParent = getNextParent(root);
        if (nextParent == null) return;

        Node rootChild = root.right == null ? root.left : root.right;
        Node nextChild = nextParent.left == null ? nextParent.right : nextParent.left;
        if (rootChild != null) rootChild.next = nextChild;
        connectCousins(nextParent);
    }

    private void traverse(Node root) {
        if (root == null) return;
        if (root.left != null && root.left.next == null || root.right != null && root.right.next == null) connectCousins(root);
        traverse(root.left);
        traverse(root.right);
    }

    private void connectChildren(Node root) {
        if (root == null) return;
        if (root.left != null && root.right != null) root.left.next = root.right;
        connectChildren(root.left);
        connectChildren(root.right);
    }

    public Node connect2(Node root) {
        connectChildren(root);
        traverse(root);
        return root;
    }

}
