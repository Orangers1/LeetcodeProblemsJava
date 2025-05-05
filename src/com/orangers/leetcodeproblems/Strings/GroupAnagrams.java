package com.orangers.leetcodeproblems.Strings;

import com.orangers.leetcodeproblems.Arrays.ArrayWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<ArrayWrapper, List<String>> result = new HashMap<>(); // map character count of each string to list of anagrams

        for(String s : strs){
            int[] count = new int[26];
            for(char c : s.toCharArray()){
                count[c - 'a'] += 1;
            }
            List<String> putList = new ArrayList<>();
            ArrayWrapper wrapper = new ArrayWrapper(count);
            if(result.containsKey(wrapper)){
                putList = result.get(wrapper);
            }
            putList.add(s);
            result.put(wrapper, putList);
        }
        return new ArrayList<>(result.values());
    }
}
