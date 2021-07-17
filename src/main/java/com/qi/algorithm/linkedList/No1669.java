package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;
import com.qi.algorithm.util.Tool;

/**
 * Description:
 *
 * 给你两个链表list1 和list2，它们包含的元素分别为n 个和m 个。
 *
 * 请你将list1中第a个节点到第b个节点删除，并将list2接在被删除节点的位置。
 *
 * Author: Qi
 * Date: 07-16-2021
 */
public class No1669 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode dummyHead1 = new ListNode();
        dummyHead1.next = list1;
        ListNode d = list2;
        while (d.next != null){
            d = d.next;
        }
        for (int i = 0; i < a; i++) {
            dummyHead1 = dummyHead1.next;
        }
        ListNode tmp = dummyHead1.next;
        dummyHead1.next = list2;
        for (int j = 0; j < b - a; j++) {
            tmp = tmp.next;
        }
        d.next = tmp.next;
        return list1;
    }

    public static void main(String[] args) {
        No1669 no1669 = new No1669();
        ListNode l = Tool.initLinkList(new int[]{0,1,2,3,4,5});
        ListNode l1 = Tool.initLinkList(new int[]{1000000,1000001,1000002});
        l = no1669.mergeInBetween(l,3,4,l1);
        Tool.printLinkList(l);
    }
}
