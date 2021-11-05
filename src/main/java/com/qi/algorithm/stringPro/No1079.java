package com.qi.algorithm.stringPro;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: Letter Tile Possibilities 活字印刷
 *
 * 思路：所有穷举法能解出来的都可以用回溯法
 *
 * Author: Qi
 * Date: 11-05-2021
 */
public class No1079 {

    Set<String> set = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        int [] visited = new int[tiles.length()];
        dfs(0, tiles, new StringBuffer(), visited);
        return set.size();
    }

    private void dfs(int index, String tiles, StringBuffer stringBuffer, int [] visited) {
        if (stringBuffer.length() != 0) set.add(stringBuffer.toString());
        if (index == tiles.length())return;
        dfs(index+1, tiles, stringBuffer, visited);
        for (int i = 0; i < tiles.length(); i++) {
            if (visited[i] == 0){
                visited[i] = 1;
                dfs(index+1, tiles, stringBuffer.append(tiles.charAt(i)), visited);
                stringBuffer.deleteCharAt(stringBuffer.length()-1);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        No1079 no1079 = new No1079();
        System.out.println(no1079.numTilePossibilities("AAB"));
    }
}
