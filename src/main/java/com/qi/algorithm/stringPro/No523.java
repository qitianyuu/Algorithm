package com.qi.algorithm.stringPro;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Continuous Subarray Sum 连续的子数组和
 *
 * 思路：连续的字串一般思路是前缀和，用 Map 保存前缀和
 *      本题还有一个技巧就是同余定理  ( pre(j) - pre (i) ) % k == 0 则 pre(j) % k == pre(i) % k
 *      因此只需要在 Map 中保存取余后的值即可。
 * Author: Qi
 * Date: 11-15-2021
 */
public class No523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < 2)return false;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum = (sum + nums[i]) % k;
            if (map.containsKey(sum)){
                int tmp = map.get(sum);
                if (i - tmp >= 2){
                    return true;
                }
            }else {
                map.put(sum, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        No523 no523 = new No523();
        System.out.println(no523.checkSubarraySum(new int[]{1, 1, 1, 1}, 10));
    }
}
