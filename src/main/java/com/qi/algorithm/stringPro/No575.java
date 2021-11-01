package com.qi.algorithm.stringPro;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: Distribute Candies 分糖果
 *
 * 思路：用 set 装糖果，最后的结果就是如果糖果种类大于 n/2 则结果就是 n/2
 *      如果糖果种类小于 n/2 则答案就是糖果种类。
 *
 * Author: Qi
 * Date: 11-01-2021
 */
public class No575 {

    public int distributeCandies(int[] candyType) {
        int mid = candyType.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int i : candyType) {
            set.add(Integer.valueOf(i));
            if (set.size() == mid){
                return mid;
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        No575 no575 = new No575();
        System.out.println(no575.distributeCandies(new int[]{1, 1, 2, 3}));
    }
}
