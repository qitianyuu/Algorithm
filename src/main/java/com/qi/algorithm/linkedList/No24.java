package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;
import com.qi.algorithm.util.Tool;

/**
 * Description:
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 升级难度：k个一组交换
 *
 * Author: Qi
 * Date: 07-15-2021
 */
public class No24 {


    //k个一组交换链表中的节点
    public ListNode reverseKgroup(ListNode head, int k){
        if (k == 1) {
            return head;
        }
        ListNode c = head;
        ListNode p = new ListNode();
        p.next = c;
        for (int i = 0; i < k; i++) {
            if (c == null){
                return head;
            }
            c = c.next;
            p = p.next;

        }
        p.next = reverseKgroup(c, k);
        return reversePN(head, k);
    }

    //交换前n个节点
    ListNode tmp;
    public ListNode reverse(ListNode head, ListNode tail){
        ListNode c = head;
        if (c.next == tail){
            tmp = tail;
            return head;
        }
        ListNode last = reverse(head.next, tail);
        head.next.next = head;
        head.next = tmp;
        return last;
    }

    //交换前n个
    public ListNode reversePN(ListNode head, int n){
        if (n == 1){
            return head;
        }
        ListNode c = head;
        for (int i = 0; i < n; i++) {
            c = c.next;
            if (c == null){
                return reverse(head, null);
            }
        }
        return reverse(head, c);
    }

    //两个一组交换
    public ListNode swapPairs(ListNode head) {
        return reverseKgroup(head, 2);
    }

    //直接递归解法
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode c = head;
        ListNode n = c.next;
        c.next = swapPairs1(n.next);
        n.next = c;
        return n;
    }

    public static void main(String[] args) {
        No24 no24 = new No24();
        ListNode l = Tool.initLinkList(new int[]{1,2,3,4,5,6});
        l = no24.swapPairs1(l);
        Tool.printLinkList(l);
    }
}
