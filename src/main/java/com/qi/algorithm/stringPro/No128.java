package com.qi.algorithm.stringPro;

import java.util.*;

/**
 * Description: Longest Consecutive Sequence 最长连续序列
 *
 * 思路：先存到set中去重复，然后针对每个数，查看他的前一位和后一位，只往后查，如果被访问了就跳过。
 *
 * Author: Qi
 * Date: 09-28-2021
 */
public class No128 {

    //排序做法，
    public int longestConsecutive(int[] nums) {
        int n = nums.length, max = -1, cur = 1;
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            if (nums[i-1] == nums[i]) continue;
            if (nums[i-1] + 1 == nums[i]){
                cur++;
            }
            else {
                max = Math.max(cur, max);
                cur = 1;
            }
        }
        return Math.max(cur, max);
    }

    //推荐做法
    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            set.add(num);
        }
        for (Integer integer : set) {
            map.put(integer, false);
        }
        int ans = 0;
        for (int num : nums) {
            if (!map.get(num) && !set.contains(num - 1)){
                int curans = 1;
                int cur = num;
                map.put(num, true);
                while (set.contains(cur + 1)){
                    cur++;
                    curans++;
                    map.put(cur, true);
                }
                ans = Math.max(curans, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No128 no128 = new No128();
        int i = no128.longestConsecutive1(new int[]{1,2,0,1});
        System.out.println(i);
    }
}
