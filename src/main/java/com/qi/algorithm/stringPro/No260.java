package com.qi.algorithm.stringPro;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: Single Number III 只出现一次的数字 III
 *
 * 思路：本题用 hash 表，记录次数，然后筛选
 *
 * Author: Qi
 * Date: 10-30-2021
 */
public class No260 {

    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int []ans = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1){
                ans[i++] = entry.getKey();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No260 no260 = new No260();
        System.out.println(Arrays.toString(no260.singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
