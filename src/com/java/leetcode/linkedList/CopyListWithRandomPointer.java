package com.java.leetcode.linkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // Map<Node,Node> map = new HashMap<>();
    // public Node copyRandomList(Node head) {
    //     if(head == null){
    //         return null;
    //     }

    //     if(map.containsKey(head)){
    //         return map.get(head);
    //     }

    //     Node newNode = new Node(head.val);
    //     map.put(head,newNode);

    //     newNode.next = copyRandomList(head.next);
    //     newNode.random = copyRandomList(head.random);

    //     return newNode;
    // }

    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node curr =  head;
        while(curr!=null){
            map.put(curr,new Node(curr.val));
            curr=curr.next;
        }

        curr=head;
        while(curr!=null){
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

}
