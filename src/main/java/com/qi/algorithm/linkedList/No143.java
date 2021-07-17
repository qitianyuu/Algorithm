package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;
import com.qi.algorithm.util.Tool;

/**
 * Description:
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 *
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 思路：先找中间节点，然后反转后半部分，然后两个链表交叉链接
 *
 * Author: Qi
 * Date: 07-16-2021
 */
public class No143 {

    public ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode c = head;
        ListNode p = null;
        ListNode n = null;
        while (c != null){
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            if (fast.next != null){
                fast = fast.next.next;
            }else {
                break;
            }
        }
        ListNode tmp = slow.next;
        Tool.printLinkList(tmp);
        slow.next = null;
        ListNode dummyHead = head;
        ListNode dummyHead1 = reverse(tmp);
        Tool.printLinkList(dummyHead);
        Tool.printLinkList(dummyHead1);
        head = dummyHead;
        while (dummyHead != null && dummyHead1 != null){
            slow = dummyHead.next;
            fast = dummyHead1.next;
            dummyHead.next = dummyHead1;
            dummyHead1.next = slow;
            dummyHead = slow;
            dummyHead1 = fast;
        }
    }

    public static void main(String[] args) {
        No143 no143 = new No143();
        ListNode l = Tool.initLinkList(new int[]{1, 2, 3, 4, 5,6});
        no143.reorderList(l);
        Tool.printLinkList(l);
    }
}
