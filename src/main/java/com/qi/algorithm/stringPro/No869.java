package com.qi.algorithm.stringPro;

/**
 * Description: Reordered Power of 2 重新排序得到 2 的幂
 *
 * 思路：一个是全排列的思路，可以看第47题
 *      如何判断是否是 2 的幂？ (n & n-1) == 0
 *
 * Author: Qi
 * Date: 10-30-2021
 */
public class No869 {

    boolean []visited;
    public boolean reorderedPowerOf2(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        visited = new boolean[nums.length];
        return dfs(nums, 0, 0);
    }

    private boolean dfs(char[] nums, int index, int num) {
        if (index == nums.length){
            return isPower2(num);
        }
        for (int i = 0; i < nums.length; i++) {
            if ((num == 0 && nums[i] == '0') || visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i-1])){
                continue;
            }
            visited[i] = true;
            if (dfs(nums, index + 1, num * 10 + nums[i] - '0')){
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    private boolean isPower2(int num) {
        return (num & (num-1)) == 0;
    }

    public static void main(String[] args) {
        No869 no869 = new No869();
        System.out.println(no869.reorderedPowerOf2(10));
    }
}
