package com.qi.algorithm.stringPro;

/**
 * Description: Subarray Product Less Than K 乘积小于 K 的子数组
 *
 * 思路：连续字串乘积可以考虑双指针，外层循环循环后面的指针，内层循环前面的
 *      然后乘积问题往往会有溢出风险，因此及时判断，不应该全部存储
 *
 * Author: Qi
 * Date: 05-05-2022
 */
public class No713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0 || k == 1){
            return 0;
        }
        int ans = 0;
        int l = 0;
        int product = 1;
        for (int r = 0; r < nums.length; r++) {
            product *= nums[r];
            while (product >= k){
                product /= nums[l];
                l++;
            }
            ans += r - l + 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        No713 n = new No713();
        System.out.println(n.numSubarrayProductLessThanK(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19));
    }
}
