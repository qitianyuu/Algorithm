package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;
import com.qi.algorithm.util.Tool;

/**
 * Description:
 * Author: Qi
 * Date: 07-16-2021
 */
public class No328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode();
        ListNode c = head;
        ListNode c1 = dummyHead;
        while (c != null && c.next != null){
            c1.next = c.next;//
            c1 = c1.next;//2
            if (c.next.next == null){
                break;
            }
            c.next = c.next.next;
            c = c.next;
        }
        c.next = dummyHead.next;
        c1.next = null;
        return head;
    }

    public static void main(String[] args) {
        No328 no328 = new No328();
        ListNode l = Tool.initLinkList(new int[]{1, 2, 3, 4, 5, 6});
        l = no328.oddEvenList(l);
        Tool.printLinkList(l);
    }
}
