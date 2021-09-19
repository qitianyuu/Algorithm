package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;

import static com.qi.algorithm.util.Tool.initLinkList;
import static com.qi.algorithm.util.Tool.printLinkList;

/**
 * Description: Add Two Numbers 两数相加
 * Author: Qi
 * Date: 09-03-2021
 */
public class No2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int add = 0, num1, num2, tmp;
        while (l1 != null || l2 != null){
            num1 = l1 == null ? 0 : l1.val;
            num2 = l2 == null ? 0 : l2.val;
            tmp = num1 + num2 + add;
            if (head == null){
                head = new ListNode(tmp % 10);
                tail = head;
            }else {
                tail.next = new ListNode(tmp % 10);
                tail = tail.next;
            }
            add = tmp / 10;
            if (l1 != null)l1 = l1.next;
            if (l2 != null)l2 = l2.next;
        }
        if (add != 0){
            tail.next = new ListNode(add);
        }
        return head;
    }

    public static void main(String[] args) {
        No2 no2 = new No2();
        ListNode l1 = initLinkList(new int[]{9,9,9,9});
        ListNode l2 = initLinkList(new int[]{9});
        l1 = no2.addTwoNumbers(l1,l2);
        printLinkList(l1);
    }
}
