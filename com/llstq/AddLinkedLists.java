package com.llstq;

import com.llstq.ListNode;

public class AddLinkedLists {
    public ListNode addTwoNumbers(com.llstq.ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode currNode  = null;
        while(l1 !=null || l2 !=null) {
            int num1= 0;
            int num2 =0;
            if (l1 != null) {
                num1 = l1.val;
            }
            if (l2 != null) {
                num2 = l2.val;
            }
            int num = num1+num2+carry;
            carry = 0;
            if(num/10 != 0) {
                carry = num/10;
                num = num%10;
            }
            ListNode node = new ListNode(num);
            if(head == null) {
                currNode = node;
                head = node;
            } else {
                currNode.next = node;
                currNode = node;
            }
            if(l1!=null) {
                l1= l1.next;
            }
            if(l2!=null) {
                l2= l2.next;
            }
        }
        if(carry >0) {
            ListNode node = new ListNode(carry);
            currNode.next = node;
        }
        return head;
    }



}
