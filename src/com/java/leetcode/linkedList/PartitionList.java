package com.java.leetcode.linkedList;

public class PartitionList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static ListNode partition(ListNode head, int x) {

        ListNode temp = new ListNode(-1);
        ListNode temp2 = temp;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                ListNode newNode = new ListNode(cur.val);
                temp.next = newNode;
                temp = temp.next;
            }
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.val >= x) {
                ListNode newNode = new ListNode(cur.val);
                temp.next = newNode;
                temp = temp.next;
            }
            cur = cur.next;
        }
        return temp2.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        ListNode head = partition(node1, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
