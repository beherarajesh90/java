package com.java.leetcode.tree.binaryTree;

import com.java.leetcode.tree.Node;

import java.util.*;

public class VerticalOrderTraversal {

    static class Pair{
        Node node;
        int dist;
        Pair(Node node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    static ArrayList<Integer> verticalOrder(Node root)
    {
        // add your code here
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        int min=0, max=0;

        while (!q.isEmpty()){
            Pair curPair = q.poll();
            Node curNode = curPair.node;
            int curDist = curPair.dist;
            map.computeIfAbsent(curDist,k -> new ArrayList<>()).add(curNode.data);
            min = Math.min(min,curDist);
            max = Math.max(max,curDist);
            if (curNode.left!=null) q.offer(new Pair(curNode.left, curDist-1));
            if (curNode.right!=null) q.offer(new Pair(curNode.right, curDist+1));
        }

        for (int key=min; key<=max; key++){
            result.addAll(map.get(key));
        }

        return result;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.left=n2;
        System.out.println(verticalOrder(n1));
    }

}
