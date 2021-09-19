package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Subsets 子集
 *
 * 思路：可以用回溯，分别把每一个非叶子节点和叶子节点都加入到 ans 中。
 *      也可以用动态规划算法，考虑每一个答案都是前一个答案加上她本身，即二倍关系
 *      例如 1，2 -> n 1 2 12 则有 1，2，3 -> n 1 2 12 + (3 13 23 123)
 *
 * Author: Qi
 * Date: 09-16-2021
 */
public class No78 {

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        if (n == 0) return ans;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            int tmp = ans.size();
            for (int j = 0; j < tmp; j++) {
                List<Integer> tmpList = new ArrayList<>(ans.get(j));
                tmpList.add(cur);
                ans.add(tmpList);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No78 no78 = new No78();
        List<List<Integer>> subsets = no78.subsets(new int[]{1, 2, 3});
        System.out.println(subsets.toString());
    }
}
