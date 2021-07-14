package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;
import com.qi.algorithm.util.Tool;

/**
 * Description:
 * Author: Qi
 *
 * 思路：
 * 1 反转链表，然后逐一对比 坑：反转链表需要重新开辟空间，不能破坏之前的原始链表
 * 2 快慢指针方法找到中间节点，然后反转后半部分，再进行比较
 *
 * Date: 07-14-2021
 */
public class No234 {

    public ListNode reverse(ListNode head){
        if (head.next == null){
            return head;
        }
        ListNode c = head;
        ListNode p = null;
        while (c != null){
            ListNode tmp = new ListNode(c.val);
            tmp.next = p;
            p = tmp;
            c = c.next;
        }
        return p;
    }

    //反转链表
    public boolean isPalindrome(ListNode head) {
        ListNode headRev = reverse(head);
        while (head != null){
            if (head.val != headRev.val){
                return false;
            }
            head = head.next;
            headRev = headRev.next;
        }
        return true;
    }

    public ListNode reverse1(ListNode head, ListNode tail){
        if (head.next == null){
            return head;
        }
        ListNode last = reverse1(head.next, tail);
        head.next.next = head;
        head.next = tail;
        return last;
    }

    //快慢指针
    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        ListNode low = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            low = low.next;
            fast = fast.next.next;
        }

        ListNode mid = low;

        low = head;
        fast = reverse1(mid.next, mid);
        mid.next = null;
        while (low != null && fast != null){
            if (low.val != fast.val){
                return false;
            }
            low = low.next;
            fast = fast.next;
        }
        return true;
    }

    public static void main(String[] args) {
        No234 no234 = new No234();
        ListNode l = Tool.initLinkList(new int[]{1});
        System.out.println(no234.isPalindrome1(l));
    }
}
