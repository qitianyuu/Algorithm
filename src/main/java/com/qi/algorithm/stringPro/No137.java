package com.qi.algorithm.stringPro;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: Single Number II 只出现一次的数字 II
 *
 * 思路：放到 set 中然后求和乘三，减去原数组求和，最后再除二得到结果
 *      还有更高效的位运算，思想是对于每一位进行加和并且对3取余，得到的一定是唯一的那个的这一位的值
 *
 * Author: Qi
 * Date: 11-18-2021
 */
public class No137 {

    public int singleNumber(int[] nums) {
        long sum = 0, sum3 = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            sum+= num;
            set.add(num);
        }
        for (Integer integer : set) {
            sum3 += integer;
        }
        return (int) (((3 * sum3) - sum) / 2);
    }

    public static void main(String[] args) {
        No137 no137 = new No137();
        System.out.println(no137.singleNumber(new int[]{2, 2, 3, 2}));
    }
}
