package com.java.leetcode.linkedList;

public class CheckIfLinkedListIsPalindrome {
    static boolean isPalindrome(Node head) {
        // Your code here
        if(head.next==null)
            return true ;
        Node slow=head,fast=head,prev=null;
        while(slow!=null && fast!=null && fast.next!=null){
            fast = fast.next.next;
            Node slowTemp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = slowTemp;
//            fast = slow.next;
        }
        if(fast!=null){
            slow=slow.next;
        }
        while(prev!=null && slow!=null){
            if(prev.data!=slow.data){
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }

    static void print(Node root){
        Node cur = root;
        while (cur!=null){
            System.out.print(cur.data+" -> ");
            cur=cur.next;
        }
    }

    static Node reverse(Node node){
        Node prev = null;
        while(node!=null){
            Node tmp = node.next;
            node.next=prev;
            prev=node;
            node=tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node n1 = new Node(375);
        Node n2 = new Node(961);
        Node n3 = new Node(677);
        Node n4 = new Node(596);
        Node n5 = new Node(1);
        Node n6 = new Node(1);
        Node n7 = new Node(596);
        Node n8 = new Node(677);
        Node n9 = new Node(961);
        Node n10 = new Node(375);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n7;
//        n6.next=n7;
        n7.next=n8;
        n8.next=n9;
        n9.next=n10;
        n10.next=null;

        System.out.println(isPalindrome(n1));
    }
}


class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}

