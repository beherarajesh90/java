package com.java.leetcode.linkedList;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int result = 0;
        int i = 0;
        ListNode curNode = new ListNode(-1);
        ListNode prev = null;
        ListNode rootNode = curNode;
        while(l1!=null && l2!=null){
            int curSum = l1.val+l2.val+carry;
            int num = curSum%10;
            carry = curSum/10;
            curNode.val = num;
            curNode.next = new ListNode(-1);
            prev = curNode;
            curNode=curNode.next;
            l1=l1.next;
            l2=l2.next;
        }
        if (l2==null){
            while (l1!=null){
                int curSum = l1.val+carry;
                int num = curSum%10;
                carry = curSum/10;
                curNode.val = num;
                curNode.next = new ListNode(-1);
                prev = curNode;
                curNode=curNode.next;
                l1=l1.next;
            }
        }else{
            while (l2 !=null){
                int curSum = l2.val+carry;
                int num = curSum%10;
                carry = curSum/10;
                curNode.val = num;
                curNode.next = new ListNode(-1);
                prev = curNode;
                curNode=curNode.next;
                l2=l2.next;
            }
        }
        if(carry>0){
            curNode.val = carry;
        }
        if(curNode.val == -1){
            prev.next = null;
        }
        return rootNode;
    }
}
