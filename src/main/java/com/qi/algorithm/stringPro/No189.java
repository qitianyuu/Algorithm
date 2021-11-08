package com.qi.algorithm.stringPro;

/**
 * Description: Rotate Array 旋转数组
 *
 * 思路：常规解法，拷贝映射覆盖
 *      强者解法：三次反转实现
 *      nums = "----->-->"; k =3
 *      result = "-->----->";
 *
 *      reverse "----->-->" we can get "<--<-----"
 *      reverse "<--" we can get "--><-----"
 *      reverse "<-----" we can get "-->----->"
 *      this visualization help me figure it out :)
 *
 * Author: Qi
 * Date: 11-08-2021
 */
public class No189 {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[(i+k)%n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = ans[i];
        }
        return;

        //常数解法
        //for (int i = 0; i < k; i++) {
        //    int p = nums[0], tmp;
        //    for (int j = 1; j < n; j++) {
        //        tmp = nums[i];
        //        nums[i] = p;
        //        p = tmp;
        //    }
        //    nums[0] = p;
        //}
    }


    public static void main(String[] args) {

    }
}
