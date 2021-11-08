package com.qi.algorithm.stringPro;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description: Largest Number 最大数
 *
 * 思路：判断每个数的第一位大小，如果相同的话比较第二位，例如 9 和 92 则 992 > 929
 *      因此比较 a+b 和 b+a 的大小决定顺序，采用优先队列，重点是优先队列的比较器。
 *
 * Author: Qi
 * Date: 11-08-2021
 */
public class No179 {

    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        for (int num : nums) {
            pq.offer(String.valueOf(num));
        }
        String ans = "";
        while (!pq.isEmpty()){
            ans += pq.poll();
        }
        if (ans.charAt(0) == '0') return "0";
        return ans;
    }

    public static void main(String[] args) {
        No179 no179 = new No179();
        System.out.println(no179.largestNumber(new int[]{3,30,34,5,9}));
    }
}
