package com.orangers.leetcodeproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZigzagGrid {
    public static void main(String[] args){
        int[][] grid = {{2,1},{2,1},{2,1}};
        System.out.println(zigzagTraversal(grid));
    }
    public static List<Integer> zigzagTraversal(int[][] grid) {
        ArrayList list = new ArrayList();
        int row = 0;
        int col = 0;
        Boolean fwds = true;
        for(int i = 0; i < grid.length*grid[0].length; i+=2){
            list.add(grid[row][col]);
            int offset;
            if(fwds){
                col+=2;
                offset = col - grid[0].length;
            }else{
                col-=2;
                offset = -col;
            }
            if(offset >= 0){
                // set col to next end
                if(fwds){
                    col = grid[0].length - offset - 1;
                }else{
                    col = offset-1;
                }
                fwds = !fwds;
                row++;
            }
        }
        return list;
    }


    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> seenCharacters = new HashMap<>();
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if(seenCharacters.containsKey(s.charAt(i))) {
                maxLength = Math.max(maxLength, seenCharacters.size());
                seenCharacters.clear();
                seenCharacters.put(s.charAt(i), i);
            } else {
                seenCharacters.put(s.charAt(i), i);
            }
        }
        return maxLength;
    }


public boolean isPalindrome(int x) {
    if (x < 0) {
        return false;
    }
    String number = Integer.toString(x);
    for(int i = 0; i < number.length()/2; i++) {
        if(number.charAt(i) != number.charAt(number.length()-i-1)){
            return false;
        }
    }
    return true;
}
}
