package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;
import com.qi.algorithm.util.Tool;

/**
 * Description:
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * Author: Qi
 * Date: 07-15-2021
 */
public class No19 {

    //快慢指针方法
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast,slow;
        slow = fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null){
            return head.next;
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        No19 no19 = new No19();
        ListNode l = Tool.initLinkList(new int[]{1,2,3,4,5});
        l = no19.removeNthFromEnd(l,1);
        Tool.printLinkList(l);
    }
}
