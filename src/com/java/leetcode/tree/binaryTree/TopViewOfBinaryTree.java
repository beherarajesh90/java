package com.java.leetcode.tree.binaryTree;

import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class TopViewOfBinaryTree {
    static class Pair{
        TreeNode node;
        int dist;
        public Pair(TreeNode node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public static List<Integer> getTopView(TreeNode root) {
        // Write your code here.
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Map<Integer, Integer> map = new HashMap<>();
        Deque<Pair> dq = new LinkedList<>();
        dq.addLast(new Pair(root, 0));
        int minDist=0, maxDist=0;
        while(!dq.isEmpty()){
            Pair curPair = dq.pollFirst();
            TreeNode curNode = curPair.node;
            int curDist = curPair.dist;

            minDist = Math.min(minDist, curDist);
            maxDist = Math.max(maxDist, curDist);

            if(!map.containsKey(curDist)){
                map.put(curDist, curNode.data);
            }

            if(curNode.left!=null){
                dq.addLast(new Pair(curNode.left, curDist-1));
            }

            if(curNode.right!=null){
                dq.addLast(new Pair(curNode.right, curDist+1));
            }
        }

        for(int start=minDist; start<=maxDist; start++){
            list.add(map.get(start));
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> topView = getTopView(root);
        System.out.println(topView);
    }
}
