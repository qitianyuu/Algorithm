package com.qi.algorithm.stringPro;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Single Number 只出现一次的数字
 *
 * 思路：hash 表可以解，还可以用异或运算，两个相同的数异或为零，0 异或任何数都是它本身
 *      因此，对所有数异或，得到的就是只出现一次的数。
 *
 * Author: Qi
 * Date: 09-27-2021
 */
public class No136 {

    public int singleNumber(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int tmp = map.getOrDefault(nums[i], 0);
            map.put(nums[i], tmp + 1);
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) == 1){
                return i;
            }
        }
        return 0;
    }

    public int singleNumber1(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public static void main(String[] args) {

        No136 no136 = new No136();
        int i = no136.singleNumber1(new int[]{4, 1, 2, 1, 2});
        System.out.println(i);
    }
}
