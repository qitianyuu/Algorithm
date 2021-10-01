package com.qi.algorithm.stringPro;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Majority Element 多数元素
 * Author: Qi
 * Date: 09-29-2021
 */
public class No169 {

    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int tmp = map.getOrDefault(nums[i], 0);
            if (tmp + 1 > n/2){
                return nums[i];
            }
            map.put(nums[i], tmp+1);
        }
        return nums[n-1];
    }

    public static void main(String[] args) {
        No169 no169 = new No169();
        int i = no169.majorityElement(new int[]{2,2,1,1,1,2,2});
        System.out.println(i);
    }
}
