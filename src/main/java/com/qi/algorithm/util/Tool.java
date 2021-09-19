package com.qi.algorithm.util;

import com.qi.algorithm.entity.ListNode;
import com.qi.algorithm.entity.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: tool
 * Author: Qi
 * Date: 06-04-2021
 */
public class Tool {

    public static void printLinkList(ListNode head){
        if (head == null){
            return;
        }
        ListNode listNode = head;
        while (listNode.next != null){
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
        System.out.println("finish!");
    }

    public static ListNode initLinkList(int[] input){
        ListNode head = new ListNode();
        ListNode c = head;
        for (int i = 0; i < input.length; i++) {
            ListNode tmp = new ListNode(input[i]);
            c.next = tmp;
            c = c.next;
        }
        return head.next;
    }

    static String SEP = ",";
    static String NULL = "#";
    public static TreeNode initTreeNode(String data){
        if(data.isEmpty()) {
            return null;
        }
        String[] list = data.split(SEP);

        String rootVal = list[0];
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for(int i = 1; i < list.length;) {
            TreeNode parent = queue.poll();
            String left = list[i++];
            if(!left.equals(NULL)) {
                parent.left = new TreeNode(Integer.parseInt(left));
                queue.offer(parent.left);
            }
            if (i < list.length){
                String right = list[i++];
                if(!right.equals(NULL)) {
                    parent.right = new TreeNode(Integer.parseInt(right));
                    queue.offer(parent.right);
                }
            }
        }
        return root;
    }

    public static void printTree(TreeNode head) {
        printInOrder(head, 0, "H", 6);
        System.out.println();
    }
    private static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "↗", len);
        String val = to + head.val;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "↘", len);
    }
    private static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }
}
