package com.qi.algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: Permutations 全排列
 *
 * 思路：回溯算法，然后每到树的最底端就向答案list添加，注意，需要做拷贝。
 *
 * Author: Qi
 * Date: 09-10-2021
 */
public class No46 {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0)return ans;
        if (nums.length == 1){
            ans.add(new ArrayList<>(Arrays.asList(nums[0])));
            return ans;
        }
        trackback(nums, ans, 0, new ArrayList<>());
        return ans;
    }

    private void trackback(int[] nums, List<List<Integer>> ans, int index, ArrayList<Integer> list) {
        if (nums.length == index){
            ans.add(new ArrayList<>(list));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (!list.contains(nums[i])){
                    list.add(nums[i]);
                    trackback(nums, ans, index + 1, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        No46 no46 = new No46();
        List<List<Integer>> permute = no46.permute(new int[]{1});
        permute.forEach(item -> {
            System.out.println(item.toString());
        });
    }
}
