package com.qi.algorithm.stringPro;

/**
 * Description: Longest Absolute File Path 文件的最长绝对路径\
 *
 * 思路: 遍历，要知道什么时候该停
 *      遇到 \n 该停止，计算前面的长度和层数长度
 *      遇到 \t 增加一层
 *      遇到 . 则是文件，
 *      最后文件需要加上层级长度和自身长度
 *
 * Author: Qi
 * Date: 2022/4/20
 */

public class No388 {

    // dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext
    public int lengthLongestPath(String input) {
        int n = input.length();
        int ans = 0;
        int pos = 0;
        int level[] = new int[n + 1];

        while (pos < n){
            // 深度
            int depth = 1;
            while (pos < n && input.charAt(pos) == '\t'){
                pos++;
                depth++;
            }

            // 长度
            int len = 0;
            boolean isfile = false;
            while (pos < n && input.charAt(pos) != '\n'){
                if (input.charAt(pos) == '.') {
                    isfile = true;
                }
                len++;
                pos++;
            }

            pos++;

            if (depth > 1) {
                len += level[depth - 1] + 1;
            }
            if (isfile) {
                ans = Math.max(ans, len);
            } else {
                level[depth] = len;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No388 no388 = new No388();
        no388.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
    }
}
