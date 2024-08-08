package com.java.leetcode.linkedList;

public class KReverseLinkedList {
    public static Node reverseK(Node head, int n, int[] b){
        if(head==null || head.next==null) return head;
        Node dummy = new Node(-1);
        dummy.next = head;

        Node prev = dummy;
        Node cur = dummy;
        Node next = dummy;

        int count = 0;
        //count all the nodes
        while (cur!=null){
            count++;
            cur=cur.next;
        }
        int j = 0;
        //iterating till next is not null
        while (next!=null && j<n){
            int k = b[j];
            if(k!=0){
                cur = prev.next;
                next = cur.next;
            }
            int loopCount = count > k ? k : count-1;
            for (int i=1; i<loopCount; i++){
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = cur.next;
            }
            prev = cur;
            count-=k;
            j++;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node n1 = new Node(5);
        Node n2 = new Node(7);
        Node n3 = new Node(8);
        Node n4 = new Node(2);
        Node n5 = new Node(4);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        Node temp = reverseK(n1,3,new int[]{1,0,2});

        while (temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
