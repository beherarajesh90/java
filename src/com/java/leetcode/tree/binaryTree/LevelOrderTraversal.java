package com.java.leetcode.tree.binaryTree;

import com.java.leetcode.tree.Node;

import java.util.*;

public class LevelOrderTraversal {
    //Function to return the level order traversal of a tree.
    static ArrayList<ArrayList<Integer>> levelOrderStoringLevelWise(Node root)
    {
        // Your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root==null) return result;

        /*Using a Deque instead of a Queue (which is an interface, and LinkedList implements both) can
        offer a small performance benefit due to its optimized handling of insertions and deletions
        from both ends.*/
        Deque<Node> dq = new LinkedList<>();
        dq.offer(root);

        while(!dq.isEmpty()){

            ArrayList<Integer> curLevel = new ArrayList<>();
            for(int i=0;i<dq.size(); i++){
                Node cur = dq.pollFirst();
                curLevel.add(cur.data);
                if(cur.left!=null) dq.add(cur.left);
                if(cur.right!=null) dq.add(cur.right);
            }
            result.add(curLevel);

        }

        return result;
    }

    static ArrayList <Integer> levelOrder(Node root)
    {
        // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            Node cur = q.poll();
            result.add(cur.data);
            if(cur.left!=null) q.offer(cur.left);
            if(cur.right!=null) q.offer(cur.right);
        }

        return result;
    }
}
