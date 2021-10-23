package com.qi.algorithm.stringPro;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Subarray Sum Equals K 和为 K 的子数组
 *
 * 思路：首先题目说是连续子数组，因此可以用 p 代表前 p 个的和，而 pi - pj-1 正是从 j 到 i 的字串的和
 *      因此，维护一个 Map，记录前 p 个和出现的次数，而走到第 i 个时，就需要判断 pi - target 的值出现了几次
 *      出现的次数就是能刚好得到字串的个数 即 pi + pj = target。注意，先放一个 {0，1} 进去防止有元素和 target
 *      相等的情况。
 *
 * Author: Qi
 * Date: 10-23-2021
 */
public class No560 {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int p = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < n; i++) {
            p += nums[i];
            ans += map.getOrDefault(p - k, 0);
            map.put(p, map.getOrDefault(p, 0)+1);
        }
        return ans;
    }

    public int subarraySum1(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }


    public static void main(String[] args) {
        No560 no560 = new No560();
        System.out.println(no560.subarraySum(new int[]{1}, 0));
    }
}
