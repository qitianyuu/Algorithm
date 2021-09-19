package com.qi.algorithm.stringPro;

/**
 * Description: Remove Duplicates from Sorted Array II 删除有序数组中的重复项 II
 *
 * 思路：双指针，间隔为保留的个数，需关注何时移动 slow 指针，fast 指针是每次都会移动的
 *      slow 指针需要在不重复时候移动，重复时候停留以做更新使用
 *
 * Author: Qi
 * Date: 09-15-2021
 */
public class No80 {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2)return n;
        int fast = 2, slow = 2;
        while (fast < n){
            if (nums[slow-2] != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        No80 no80 = new No80();
        int i = no80.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
        System.out.println(i);
    }
}
