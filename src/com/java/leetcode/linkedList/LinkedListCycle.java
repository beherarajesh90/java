package com.java.leetcode.linkedList;

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        while(slowPointer != null && fastPointer!=null && fastPointer.next!=null){
            if(slowPointer == fastPointer){
                return true;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}


