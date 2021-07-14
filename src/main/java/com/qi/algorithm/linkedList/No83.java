package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;
import com.qi.algorithm.util.Tool;

/**
 * Description: 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * Author: Qi
 * Date: 07-14-2021
 */
public class No83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode c = head;
        while (c != null && c.next != null){
            if (c.val == c.next.val){
                c.next = c.next.next;
            }else {
                c = c.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l = Tool.initLinkList(new int[]{1, 1, 1});
        No83 no83 = new No83();
        Tool.printLinkList(l);
        l = no83.deleteDuplicates(l);
        Tool.printLinkList(l);
    }

}
