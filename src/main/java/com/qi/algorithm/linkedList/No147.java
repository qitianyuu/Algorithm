package com.qi.algorithm.linkedList;

import com.qi.algorithm.entity.ListNode;
import com.qi.algorithm.util.Tool;

/**
 * Description:
 *
 * 对链表进行插入排序。
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * Author: Qi
 * Date: 07-17-2021
 */
public class No147 {

    public ListNode insertionSortList(ListNode head) {
        if (head.next == null){
            return head;
        }
        //2,1,3
        ListNode last = insertionSortList(head.next);
        ListNode tmp = new ListNode();
        tmp.next = last;
        head.next = null;
        while (tmp.next != null){
            if (head.val > tmp.next.val){
                tmp = tmp.next;
            }else {
                //1,2,3,4,5,6,8
                head.next = tmp.next;
                tmp.next = head;
            }
        }
        if (tmp.next != head){
            tmp.next = head;
        }
        return last;
    }

    public static void main(String[] args) {
        No147 no147 = new No147();
        ListNode l = Tool.initLinkList(new int[]{5,2,3,8,9});
        l = no147.insertionSortList(l);
        Tool.printLinkList(l);
    }
}
