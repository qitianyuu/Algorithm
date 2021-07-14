package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;
import com.qi.algorithm.util.Tool;

/**
 * Description:
 *  给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * Author: Qi
 * Date: 07-14-2021
 */
public class No203 {

    //迭代方法
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }
        ListNode head1 = new ListNode();
        head1.next = head;
        ListNode tmp = head1;
        while (tmp.next != null){
            if (tmp.next.val == val){
                tmp.next = tmp.next.next;
            }else {
                tmp = tmp.next;
            }
        }
        return head1.next;
    }

    //递归方法
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null){
            return head;
        }
        head.next = removeElements1(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        No203 no203 = new No203();
        ListNode l = Tool.initLinkList(new int[]{1, 2, 2});
        Tool.printLinkList(no203.removeElements1(l,2));
    }
}
