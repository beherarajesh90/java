package com.java.leetcode.tree.binaryTree;

import com.java.leetcode.tree.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal {
    ArrayList<Integer> zigZagTraversal(Node root)
    {
        //Add your code here.
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Deque<Node> dq = new LinkedList<>();
        dq.add(root);
        boolean reverse = false;
        while(!dq.isEmpty()){
            int levelNodes = dq.size();
            for(int i=0; i<levelNodes; i++){
                zigZagTraversalHelper(dq,list, reverse);
            }
            reverse=!reverse;
        }

        return list;
    }

    void zigZagTraversalHelper(Deque<Node> dq, ArrayList<Integer> list, boolean reverse){
        if(!reverse){
            Node node = dq.removeLast();
            list.add(node.data);
            if(node.left!=null) dq.addFirst(node.left);
            if(node.right!=null) dq.addFirst(node.right);
        }else{
            Node node = dq.removeFirst();
            list.add(node.data);
            if(node.right!=null) dq.addLast(node.right);
            if(node.left!=null) dq.addLast(node.left);
        }
    }

    ArrayList<Integer> zigZagTraversal2(Node root)
    {
        //Add your code here.
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Queue<Node> dq = new LinkedList<>();
        dq.add(root);
        boolean reverse = false;
        while(!dq.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            int levelNodes = dq.size();
            for(int i=0; i<levelNodes; i++){
                zigZagTraversalHelper2(dq,level, reverse);
            }
            if(!reverse){
                for(int i=0; i<level.size(); i++){
                    list.add(level.get(i));
                }
            }else{
                for(int i=level.size()-1; i>=0; i--){
                    list.add(level.get(i));
                }
            }
            reverse=!reverse;
        }

        return list;
    }

    void zigZagTraversalHelper2(Queue<Node> dq, ArrayList<Integer> level, boolean reverse){
        Node node = dq.remove();
        level.add(node.data);
        if(node.left!=null) dq.add(node.left);
        if(node.right!=null) dq.add(node.right);
    }
}
