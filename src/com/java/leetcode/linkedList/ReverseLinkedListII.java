package com.java.leetcode.linkedList;

public class ReverseLinkedListII {
    private static ListNode reverse(ListNode head, int n){
        ListNode cur = head, prev = null, nextNode = null;

        for(int i=0; i<n; i++){
            nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        head.next = nextNode;

        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int n = right-left+1;
        if(n < 2)
            return head;
        else if(left==1)
            return reverse(head,n);
        else{
            ListNode temp = head;
            for(int i=2; i<left; i++){
                temp = temp.next;
            }
            temp.next=reverse(temp.next,n);
            return head;
        }
    }
}
