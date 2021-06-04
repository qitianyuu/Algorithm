package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;

import static com.qi.algorithm.util.Tool.*;

/**
 * Description:翻转链表
 * Author: Qi
 * Date: 06-04-2021
 */
public class No206 {
    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode c = head;
        while (c != null){
            ListNode n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }

    public static void main(String[] args) {
        No206 no206 = new No206();
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode l3 = new ListNode();
        ListNode l4 = new ListNode();
        ListNode l5 = new ListNode();
        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(l4);
        l4.setNext(l5);
        l1.setVal(1);
        l2.setVal(2);
        l3.setVal(3);
        l4.setVal(4);
        l5.setVal(5);
        printLinkList(l1);
        l1 = no206.reverseList(l1);
        printLinkList(l1);
    }
}
