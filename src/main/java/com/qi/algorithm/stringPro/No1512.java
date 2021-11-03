package com.qi.algorithm.stringPro;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Number of Good Pairs 好数对的数目
 *
 * 思路：统计每个数出现的次数，然后对每个值进行全排列公式的计算得出答案
 *
 * Author: Qi
 * Date: 11-02-2021
 */
public class No1512 {

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Integer value : map.values()) {
            if (value >= 2) ans += calcu(value);
        }
        return ans;
    }

    private int calcu(Integer n) {
        return (n * (n - 1))/2;
    }

    public static void main(String[] args) {
        No1512 no1512 = new No1512();
        System.out.println(no1512.numIdenticalPairs(new int[]{1,2,3,1,1,3}));
    }
}
