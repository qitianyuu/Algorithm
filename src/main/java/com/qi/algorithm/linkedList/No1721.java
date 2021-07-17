package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;
import com.qi.algorithm.util.Tool;

/**
 * Description:
 *
 * 给你链表的头节点 head 和一个整数 k 。
 *
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 *
 * Author: Qi
 * Date: 07-16-2021
 */
public class No1721 {

    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode dummyHead = new ListNode();
        ListNode dummyHead1 = new ListNode();
        dummyHead1.next = dummyHead;
        dummyHead.next = head;
        //找第k个
        ListNode pk = dummyHead1;
        for (int i = 0; i < k; i++) {
            pk = pk.next;
        }
        //查找倒数k个
        ListNode fast,bk;
        bk = dummyHead;
        fast = pk;
        while (fast.next.next != null){
            fast = fast.next;
            bk = bk.next;
        }

        if (pk.next == bk.next){
            return dummyHead.next;
        }

        if (pk.next.next == bk.next){
            ListNode tmp;
            pk.next = bk.next;
            tmp = bk.next.next;
            bk.next.next = bk;
            bk.next = tmp;
            return dummyHead;

        }
        if (bk.next.next == pk.next){
            ListNode tmp;
            bk.next = pk.next;
            tmp = pk.next.next;
            pk.next.next = pk;
            pk.next = tmp;
            return dummyHead;
        }
        //交换两个节点 pk.next 和 bk.next
        ListNode a, b, c;
        a = pk.next;
        b = bk.next;
        c = a.next;
        a.next = b.next;
        b.next = c;
        pk.next = b;
        bk.next = a;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        No1721 no1721 = new No1721();
        ListNode l = Tool.initLinkList(new int[]{7,9,6,6,7,8,3,0,9,5});
        no1721.swapNodes(l,5);
        Tool.printLinkList(l);
    }
}
