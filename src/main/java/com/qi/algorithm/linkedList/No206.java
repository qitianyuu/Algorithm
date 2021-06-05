package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;

import static com.qi.algorithm.util.Tool.printLinkList;

/**
 * Description:给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * Author: Qi
 * Date: 06-04-2021
 */
public class No206 {
    /**
     * 迭代算法
     * @param head
     * @return
     */
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

    /**
     * 递归算法
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head){
        if (head.next == null){return head;}
        ListNode last = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        No206 no206 = new No206();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(l4);
        l4.setNext(l5);
        printLinkList(l1);
        l1 = no206.reverseList1(l1);
        printLinkList(l1);
        l1 = no206.reverseList1(l1);
        printLinkList(l1);
    }
}
