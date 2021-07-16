package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;
import com.qi.algorithm.util.Tool;

/**
 * Description:
 *
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * Author: Qi
 * Date: 07-15-2021
 */
public class No86 {

    public ListNode partition(ListNode head, int x) {

        if (head == null){
            return null;
        }
        ListNode tmp1,tmp2;
        ListNode maxHead = new ListNode();
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode c = dummyHead.next;
        tmp1 = dummyHead;
        tmp2 = maxHead;
        while (c != null){
            if (c.val >= x){
                if (maxHead.next == null){
                    maxHead.next = c;
                }
                tmp2.next = c;
                tmp2 = tmp2.next;
                c = c.next;
            }else {
                tmp1.next = c;
                tmp1 = tmp1.next;
                c = c.next;
            }
            Tool.printLinkList(dummyHead.next);
            Tool.printLinkList(maxHead.next);
        }

        //这一步很关键，需要给后面的置为空，否则会出现环路
        tmp2.next = null;
        tmp1.next = maxHead.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        No86 no86 = new No86();
        ListNode l = Tool.initLinkList(new int[]{1,4,3,2,5,2});
        l = no86.partition(l,3);
        Tool.printLinkList(l);
    }
}
