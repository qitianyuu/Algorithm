package com.qi.algorithm.stringPro;

/**
 * Description: Circular Array Loop 环形数组是否存在循环
 *
 * 思路：自己的思路是挨个遍历，然后绕一圈找到就返回 true，但是需要增加判断，尤其是当步数远大于数组长度时，要防止越界
 *
 *      找环的核心思路: 双指针 双指针的要点: 1 需要对快指针判断下一步的下一步，因为他一次走两步
 *                                       2 快慢指针相遇时就是一个环
 *
 * Author: Qi
 * Date: 09-17-2021
 */
public class No457 {

    // 最普通的方法，挨个遍历
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length == 0)return false;
        int n = nums.length;
        if (n == 2){
            if (nums[0] * nums[1] == 1)return true;
            else return false;
        }
        for (int i = 0; i < n; i++) {
            int flag = nums[i] > 0 ? 1 : -1;
            int tmp = 0, step = nums[i], pstep = i;
            while (true){
                tmp++;
                int nextIndex = (pstep + step + n) % n;
                while (nextIndex < 0) {
                    nextIndex = (nextIndex + n) % n;
                }
                if (nums[nextIndex] * flag < 0)break;
                if (tmp > n)break;
                if (nextIndex == i && nextIndex != pstep)return true;
                pstep = (pstep + step + n) % n;
                while (pstep < 0){
                    pstep = (pstep + n) % n;
                }
                step = nums[nextIndex];
            }
        }
        return false;
    }

    // 双指针解法
    public boolean circularArrayLoop1(int[] nums) {
        int n = nums.length;
        if (n < 2)return false;
        if (n == 2){
            if (nums[0] * nums[1] == 1)return true;
            else return false;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)continue;
            int slow = i, fast = next(nums, i);
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0){
                if (slow == fast){
                    if (slow != next(nums, slow)){
                        return true;
                    }else {
                        break;
                    }
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            // 下面把遍历过的点做标记
            int tmp = i, tmp1;
            while (nums[tmp] * nums[next(nums, tmp)] > 0){
                tmp1 = nums[tmp];
                tmp = next(nums, tmp);
                nums[tmp1] = 0;

            }
        }
        return false;
    }

    private int next(int[] nums, int i) {
        int n = nums.length;
        return ((i + nums[i]) % n + n) % n;
    }


    public static void main(String[] args) {
        No457 no457 = new No457();
        boolean b = no457.circularArrayLoop1(new int[]{-2,-3,-9});
        System.out.println(b);
    }
}
