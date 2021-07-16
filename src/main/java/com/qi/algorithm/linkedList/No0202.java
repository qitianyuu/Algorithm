package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;
import com.qi.algorithm.util.Tool;

/**
 * Description:
 *  返回倒数第 k 个节点
 * Author: Qi
 * Date: 07-15-2021
 */
public class No0202 {

    public ListNode reverse(ListNode head){
        if (head.next == null){
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public int kthToLast(ListNode head, int k) {
        ListNode headrev = reverse(head);
        for (int i = 0; i < k - 1; i++) {
            headrev = headrev.next;
        }
        return headrev.val;
    }

    public static void main(String[] args) {
        No0202 no0202 = new No0202();
        ListNode l = Tool.initLinkList(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(no0202.kthToLast(l,3));
    }
}
