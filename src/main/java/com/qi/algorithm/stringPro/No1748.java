package com.qi.algorithm.stringPro;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Sum of Unique Elements 唯一元素的和
 * Author: Qi
 * Date: 02-06-2022
 */
public class No1748 {

    public int sumOfUnique(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer item : map.keySet()) {
            if (map.get(item) == 1) ans += item;
        }
        return ans;
    }

    public static void main(String[] args) {
        No1748 no1748 = new No1748();
        System.out.println(no1748.sumOfUnique(new int[]{1,1,1,1,1}));
    }
}
