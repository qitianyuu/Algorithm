package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;
import com.qi.algorithm.util.Tool;

/**
 * Description:
 *  给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * Author: Qi
 * Date: 07-15-2021
 */
public class No61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return head;
        }
        if (k == 0){
            return head;
        }
        int total = 1;
        ListNode tail = head;
        while (tail.next != null){
            tail = tail.next;
            total++;
        }
        //难就难在这
        k = total - k % total;
        if (total == k){
            return head;
        }

        tail.next = head;
        tail.next = head;
        for (int i = 0; i < k; i++) {
            tail = tail.next;

        }
        head = tail.next;
        tail.next = null;
        return head;
    }

    public static void main(String[] args) {
        No61 no61 = new No61();
        ListNode l = Tool.initLinkList(new int[]{0, 1, 2});
        Tool.printLinkList(l);
        l = no61.rotateRight(l,3);
        Tool.printLinkList(l);


    }
}
