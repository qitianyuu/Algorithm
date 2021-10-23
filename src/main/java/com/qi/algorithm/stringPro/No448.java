package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Find All Numbers Disappeared in an Array 找到所有数组中消失的数字
 *
 * 思路：哈希表来检查每个数字出现与否，但是需要额外的 n 个空间，考虑能否用自带的空间
 *      由于所有元素均比 n 小，因此可以用是否大于 n 来判断，取数时只需要对 n 取模就能获得真实值。
 *
 * Author: Qi
 * Date: 10-23-2021
 */
public class No448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            nums[(num-1)%n] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) ans.add(i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        No448 no448 = new No448();
        System.out.println(no448.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
