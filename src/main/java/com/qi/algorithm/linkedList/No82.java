package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;
import com.qi.algorithm.util.Tool;

/**
 * Description:
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，
 *
 * 请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * Author: Qi
 * Date: 07-15-2021
 */
public class No82 {

    //记录一个假头节点，如果对本节点操作，需要用c.next 这样不用记录它的头节点
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode c = dummyHead;
        while (c.next != null && c.next.next != null){
            if (c.next.val == c.next.next.val){
                int x = c.next.val;
                while (c.next != null && c.next.val == x){
                    c.next = c.next.next;
                }
            }else {
                c = c.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        No82 no82 = new No82();
        ListNode l = Tool.initLinkList(new int[]{1, 1, 1, 6});
        l = no82.deleteDuplicates(l);
        Tool.printLinkList(l);
    }
}
