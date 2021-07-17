package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;
import com.qi.algorithm.util.Tool;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 *
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * Author: Qi
 * Date: 07-16-2021
 */
public class No445 {

    //栈
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       Deque<Integer> stack1 = new LinkedList<>();
       Deque<Integer> stack2 = new LinkedList<>();

       while (l1 != null){
           stack1.push(l1.val);
           l1 = l1.next;
       }
        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int ten = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || ten != 0){
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int ans = a + b + ten;
            ten = ans / 10;
            ans = ans % 10;
            ListNode tmp = new ListNode(ans);
            tmp.next = head;
            head = tmp;
        }
        return head;

    }

    public static void main(String[] args) {
        No445 no445 = new No445();
        ListNode l1 = Tool.initLinkList(new int[]{3, 5, 3, 8, 4});
        ListNode l2 = Tool.initLinkList(new int[]{1});
        ListNode ans = no445.addTwoNumbers(l1, l2);
        Tool.printLinkList(ans);
    }
}
