package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 3Sum 三数之和
 * Author: Qi
 * Date: 09-10-2021
 */
public class No15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        // 第一重循环
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            // 左右指针，左指针从左至右，右指针从右至左
            int left = i + 1;
            int right = n - 1;
            //二重循环
            while (left < right){
                // 太小
                if (nums[left] + nums[right] < -nums[i]){
                    left++;
                }else if (nums[left] + nums[right] > -nums[i]){
                    //太大
                    right--;
                }else {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    //左右各移动一位
                    left++;right--;
                    while (left < right && nums[left] == nums[left-1])left++;
                    while (left < right && nums[right] == nums[right+1])left--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No15 no15 = new No15();
        List<List<Integer>> lists = no15.threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});
        lists.forEach(item ->{
            System.out.println(item.toString());
        });
    }

}
