package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;
import com.qi.algorithm.util.Tool;

/**
 * Description: 合并两个有序链表
 * Author: Qi
 * Date: 07-13-2021
 */
public class No21 {

    //迭代解法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode head;
        ListNode c = new ListNode();
        head = c;
        while (true){
            if (l1.val < l2.val){
                c.next = l1;
                l1 = l1.next;
            }else {
                c.next = l2;
                l2 = l2.next;
            }
            c = c.next;
            if (l1 == null){
                c.next = l2;
                break;
            }
            if (l2 == null){
                c.next = l1;
                break;
            }
        }
        return head.next;
    }

    //递归解法
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if(l1.val < l2.val){
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }


    public static void main(String[] args) {
        No21 no21 = new No21();
        ListNode l1 = Tool.initLinkList(new int[]{1, 2, 4});
        ListNode l2 = Tool.initLinkList(new int[]{1, 3, 4});

        Tool.printLinkList(l1);
        Tool.printLinkList(l2);
        l1 = no21.mergeTwoLists1(l1,l2);
        Tool.printLinkList(l1);

    }
}
