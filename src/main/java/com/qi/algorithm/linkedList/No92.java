package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;

import static com.qi.algorithm.util.Tool.printLinkList;

/**
 * Description:给你单链表的头指针 head 和两个整数 left 和 right ,其中 left <= right。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表。
 * Author: Qi
 * Date: 06-04-2021
 */
public class No92 {
    //step 1 反转前n个节点
    ListNode tmp = null;
    public ListNode reverseN(ListNode head, int n){
        if (n == 1){
            tmp = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = tmp;
        return last;
    }
    //step 2 利用前面的方法完成题目
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1){
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }


    public static void main(String[] args) {
        No92 no92 = new No92();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(l4);
        l4.setNext(l5);
        l5.setNext(l6);
        l6.setNext(l7);
        l7.setNext(l8);
        printLinkList(l1);
        l1 = no92.reverseBetween(l1, 2,5);
        printLinkList(l1);
    }
}
