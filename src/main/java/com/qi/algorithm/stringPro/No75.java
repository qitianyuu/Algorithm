package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description: Sort Colors 颜色分类
 *
 * 思路：通过双指针，记录 1 和 2 的位置信息，然后一次遍历并交换得到目标数据
 *
 * Author: Qi
 * Date: 09-14-2021
 */
public class No75 {

    public void sortColors(int[] nums) {
        int i1 = -1, i2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 && i1 == -1){
                i1 = i;
            }else if (nums[i] == 2 && i2 == -1){
                i2 = i;
            }
            if (i > 0){
                if (nums[i] == 0 && i1 != -1){
                    nums[i] = 1;
                    nums[i1] = 0;
                    i1 = nums[i1 + 1] != 1 ? i : i1 + 1;
                }
                if (nums[i] == 0 && i2 != -1){
                    nums[i] = 2;
                    nums[i2] = 0;
                    i2 = nums[i2 + 1] != 2 ? i : i2 + 1;
                }
                if (nums[i] == 1 && i2 != -1){
                    nums[i] = 2;
                    nums[i2] = 1;
                    i1 = i1 == i ? i2 : i1;
                    i2 = nums[i2 + 1] != 2 ? i : i2 + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        No75 no75 = new No75();
        int []a = new int[]{2,0,1};
        no75.sortColors(a);
        System.out.println(Arrays.toString(a));
    }
}
